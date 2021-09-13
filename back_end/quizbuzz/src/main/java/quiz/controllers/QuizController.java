package quiz.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import quiz.dao.UserDAO;
import quiz.models.Quiz;
import quiz.models.User;
import quiz.services.QuizManager;
import quiz.services.UserManager;

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

	@GetMapping(produces = "application/json")
	public List<Quiz> getAll() {
		return manager.findAll();
	}
}
