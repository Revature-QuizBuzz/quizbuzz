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

import java.util.List;

@RestController
@EnableTransactionManagement
@RequestMapping(path = "quizzes")
public class QuizController {

    @Autowired
    private QuizManager manager;

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

    @PutMapping(path = "/{quizId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Quiz> updateQuiz(@PathVariable int quizId, @RequestBody Quiz quiz) {
        manager.updateQuiz(quizId, quiz);
        return new ResponseEntity<>(manager.getQuizById(quizId), HttpStatus.NO_CONTENT); // status code 204, means successful put
    }
}
