package quiz.controllers;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quiz.models.*;
import quiz.services.*;


@RestController
@RequestMapping("/testresults")
@CrossOrigin(origins = "http://localhost:4200")
public class ScoresController {
	
	@Autowired
	private ScoresManager score;

	private static final Logger log = LogManager.getLogger(TagsController.class);

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<Scores> addScore(@RequestBody Scores us) {
		Scores userScores = score.create(us);
		log.info("Submit User Answers");
		return new ResponseEntity<>(userScores, HttpStatus.CREATED);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping(path="/MyScore/{id}", produces="application/json")
	public ResponseEntity<Integer> getMyScore(@PathVariable int id) {
		log.info("GET to /MyScore/" + id);
		int total = score.getMyScores(id).stream().mapToInt(s -> s.getScore()).sum();
		return new ResponseEntity<>(total, HttpStatus.ACCEPTED);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path = "/submitQuiz", produces = "application/json", consumes = "application/json")
	public Scores create(@RequestBody Scores scores) {
		log.info("Submitted user Quiz");
		scores.setCompletedOn(new Date()) ;
		return score.create(scores);
	}
}
