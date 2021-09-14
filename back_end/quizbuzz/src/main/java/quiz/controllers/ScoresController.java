package quiz.controllers;

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
import java.util.Optional;
import quiz.models.*;
import quiz.services.*;


@RestController
@RequestMapping("/testresults")
public class ScoresController {
	
	@Autowired
	private ScoresManager score;

	private static final Logger log = LogManager.getLogger(TagsController.class);

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<Scores> addScore(@RequestBody Scores us) {
		Scores userScores = score.addScore(us);
		log.info("Submit User Answers");
		return new ResponseEntity<>(userScores, HttpStatus.CREATED);
	}//Posting the user score to the database. Need to get User Answers
	
//	@CrossOrigin(origins = "http://localhost:4200")
//	@GetMapping
//	public ResponseEntity<List<Answers>> getAllAnswers() {
//		List<Answers> answers = answer.getAllAnswers();
//		log.info("Listing Answers");
//		return new ResponseEntity<List<Answers>>(answers, HttpStatus.OK);
//	} //Getting Answers to compare with the front end
	
//	@CrossOrigin(origins = "http://localhost:4200")
//	@PostMapping(consumes = "application/json", produces = "application/json")
//	public Scores createTest(@RequestBody Scores us) {
//		Scores userScores = score.create(us);
//		return userScores;
//	}

//	@GetMapping
//	public ResponseEntity<List<Answers>> getAnswersById() {
//		List<Answers> answers = score.findById(0);
//		return new ResponseEntity<>(answers, HttpStatus.OK);
//	}

}