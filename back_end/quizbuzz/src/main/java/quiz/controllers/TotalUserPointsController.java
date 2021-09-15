package quiz.controllers;

import java.util.List;

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
	
	@Autowired
	private ScoresManager manager;
	
	// Returns all scores
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(produces = "application/json", consumes = "application/json")
	public List<Scores> getAllScores() {
		return manager.findAll();
	}
	
	// Add user score
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(produces = "application/json", consumes = "application/json")
	public Scores addUserScore(@RequestBody Scores score) {
		return manager.newScore(score);
	}
	
	

}
