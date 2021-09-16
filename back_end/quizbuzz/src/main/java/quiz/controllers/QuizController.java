package quiz.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quiz.models.Quiz;
import quiz.services.QuizManager;

@RestController
@RequestMapping(path = "quizzes")
public class QuizController {

	@Autowired
	private QuizManager manager;

	private static final Logger logger = LogManager.getLogger(QuizController.class);

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path = "/createQuiz", produces = "application/json", consumes = "application/json")
	public Quiz create(@RequestBody Quiz quiz) {
		logger.info("created new quiz");
		return manager.create(quiz);
	}

	@GetMapping(produces = "application/json")
	public List<Quiz> getAll() {
		return manager.findAll();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping(path = "/{quizId}", produces = "application/json")
	public ResponseEntity<Quiz> deleteQuiz(@PathVariable("quizId") Integer quizId) {
		// LOGGER.info(MessageFormat.format("Calling delete method on quiz id:
		// {quizId}", quizId));
		manager.deleteQuiz(quizId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
