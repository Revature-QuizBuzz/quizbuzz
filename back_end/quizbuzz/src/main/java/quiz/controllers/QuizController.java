package quiz.controllers;

import java.text.MessageFormat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quiz.models.Quiz;
import quiz.services.QuizManager;

@RestController
@RequestMapping("/quizzes")
public class QuizController {
	
	@Autowired
	private QuizManager quizManager;
	
	private static final Logger LOGGER = LogManager.getLogger(QuizController.class);
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping(path="/{quizId}", produces = "application/json")
	public ResponseEntity<Quiz> deleteQuiz(@PathVariable("quizId") Integer quizId) {
//		LOGGER.info(MessageFormat.format("Calling delete method on quiz id: {quizId}", quizId));
		quizManager.deleteQuiz(quizId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
