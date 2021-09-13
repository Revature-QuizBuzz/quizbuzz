package quiz.controllers;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quiz.models.Answers;
import quiz.services.AnswersManager;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/testresults")
public class AnswerController {

	@Autowired
	private AnswersManager answer;
	
	private static final Logger log = LogManager.getLogger(TagsController.class);
	
	
	@GetMapping(path ="/answers",produces = "application/json")
	public List<Answers> getAllAnswers() {
		log.info("Listing Answers");
		return this.answer.getAllAnswers();
	} //Getting Answers to compare with the front end

}
