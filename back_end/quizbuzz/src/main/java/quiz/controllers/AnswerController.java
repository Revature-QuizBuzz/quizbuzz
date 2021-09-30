package quiz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quiz.models.Answers;
import quiz.services.AnswersManager;



@RestController
@RequestMapping(path = "/answers")
@CrossOrigin(origins = "http://localhost:4200")
public class AnswerController {
	
	private static final Logger log = LogManager.getLogger(TagsController.class);
	// Create logger for debugging 
	
	@Autowired
	private AnswersManager manager;
	
	@GetMapping(path = "/{id}", produces = "application/json")
	public List<Answers> findById(@PathVariable int id) {
		return manager.findAll(id);
	}
	
	@GetMapping(path ="/testresults",produces = "application/json")
	public List<Answers> getAllAnswers() {
		log.info("Listing Answers");
		return this.manager.getAllAnswers();
	} //Getting Answers to compare with the front end

}
