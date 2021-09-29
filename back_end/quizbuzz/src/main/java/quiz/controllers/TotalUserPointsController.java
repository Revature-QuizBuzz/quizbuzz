package quiz.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quiz.models.Scores;
import quiz.services.ScoresManager;

@RestController
@RequestMapping(path = "/scores")
public class TotalUserPointsController {
	
	public static final Logger logger = LogManager.getLogger(TotalUserPointsController.class);
	
	@Autowired
	private ScoresManager manager;
	
	// Returns all scores
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(produces = "application/json", consumes = "application/json")
	public List<Scores> getAllScores() {
		logger.info("GET to /scores");
		return manager.findAll();
	}
	
	// Add user score
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(produces = "application/json", consumes = "application/json")
	public Scores addUserScore(@RequestBody Scores score) {
		logger.info("POST to /scores");
		return manager.newScore(score);
	}
	
	

}
