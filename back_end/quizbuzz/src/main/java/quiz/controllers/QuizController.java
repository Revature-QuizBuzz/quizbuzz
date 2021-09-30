package quiz.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import quiz.models.Answers;
import quiz.models.Question;
import quiz.models.Quiz;
import quiz.models.User;
import quiz.services.AnswersManager;
import quiz.services.QuestionManager;
import quiz.services.QuizManager;


import java.util.List;

@RestController
@RequestMapping(path = "quizzes")
public class QuizController {

	@Autowired
	private QuizManager manager;
	@Autowired
	private QuestionManager questionManager;
	@Autowired
	private AnswersManager answersManager;


	private static final Logger logger = LogManager.getLogger(QuizController.class);

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path = "/createQuiz", produces = "application/json", consumes = "application/json")
	public Quiz create(@RequestBody Quiz quiz) {
		logger.info("created new quiz");
		quiz = manager.create(quiz);
		for(Question questions : quiz.getQuestions()) {
			questions.setQuiz(quiz);
			questionManager.create(questions);
			for (Answers answers : questions.getAnswers()) {
				answers.setQuestion(questions);
				answersManager.create(answers);
			}
			
		}		
		return quiz;
	}

	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping(path="", produces = "application/json")
	public List<Quiz> getAll() {
		logger.info("GET to /quizzes");
		return manager.findAll();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping(path = "/{quizId}", produces = "application/json")
	public ResponseEntity<String> deleteQuiz(@PathVariable("quizId") Integer quizId) {
		// LOGGER.info(MessageFormat.format("Calling delete method on quiz id:
		// {quizId}", quizId));
		manager.deleteQuiz(quizId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(path="/user/{userId}", produces="application/json")
	public List<Quiz> findQuizzesCreatedByUser(@PathVariable int userId){
		logger.info("Find quiz(zes) created by user ");
		return manager.findByUser(userId);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping(path="/getTen", produces="application/json")
	public ResponseEntity<List<Quiz>> getTenQuizzes() {
		logger.info("GET to /getTen");
		return new ResponseEntity<>(manager.getFeaturedQuizzes(), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path="/search/{quizName}", produces="application/json")
	public List<Quiz> findBySearchValue(@PathVariable String quizName) {
		return manager.findByQuizName(quizName);
	}
	
	
}
