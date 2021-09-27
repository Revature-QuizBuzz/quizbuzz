package quiz.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import quiz.models.Quiz;
import quiz.services.QuizManager;

import java.util.List;

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

	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping(path="", produces = "application/json")
	public List<Quiz> getAll() {
		logger.info("GET to /quizzes");
		return manager.findAll();
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping(path="/getTen", produces="application/json")
	public ResponseEntity<List<Quiz>> getTenQuizzes() {
		logger.info("GET to /getTen");
		return new ResponseEntity<>(manager.getFeaturedQuizzes(), HttpStatus.OK);
	}
}
