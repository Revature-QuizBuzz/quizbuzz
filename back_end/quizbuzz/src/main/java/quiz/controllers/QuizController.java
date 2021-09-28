package quiz.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;
import quiz.models.Quiz;
import quiz.services.QuizManager;

import quiz.models.Question;
import quiz.models.Quiz;
import quiz.models.User;
import quiz.services.QuestionManager;
import quiz.services.QuizManager;

import java.util.List;

@RestController
//@EnableTransactionManagement
@RequestMapping(path = "quizzes")
public class QuizController {

    @Autowired
    private QuizManager manager;
	@Autowired
	private QuestionManager qmanager;

    private static final Logger logger = LogManager.getLogger(QuizController.class);

    @GetMapping(produces = "application/json")
    public List<Quiz> getAll(){
        return manager.findAll();
    }

    @GetMapping(path = "/{quizId}", produces = "application/json")
    public ResponseEntity<Quiz> getQuizById(@PathVariable int quizId) {
        Quiz tempQuiz = manager.getQuizById(quizId);
        return new ResponseEntity<>(tempQuiz, HttpStatus.OK);
    }
	
	@GetMapping(path="/user/{userId}", produces="application/json")
	public List<Quiz> findQuizzesCreatedByUser(@PathVariable int userId){
		logger.info("Find quiz(zes) created by user ");
		return manager.findByUser(userId);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path = "/createQuiz", produces = "application/json", consumes = "application/json")
	public Quiz create(@RequestBody Quiz quiz) {
		logger.info("created new quiz");
		quiz = manager.create(quiz);
		for (Question questions : quiz.getQuestions()) {
			questions.setQuiz(quiz);
		}
		qmanager.createAll(quiz.getQuestions());
		return quiz;
	}

    @PutMapping(path = "/edit/{quizId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Quiz> updateQuiz(@PathVariable int quizId, @RequestBody Quiz quiz) {
    	
    	logger.info("Calling update quiz from controller with id: " + quizId + " and quiz: " + ", name: " +
    quiz.getName() + ", total score: " + quiz.getTotalScore() + ", questions: " + quiz.getQuestions());
    	
        manager.updateQuiz(quizId, quiz);
        return new ResponseEntity<>(manager.getQuizById(quizId), HttpStatus.NO_CONTENT); // status code 204, means successful put
    }
}
