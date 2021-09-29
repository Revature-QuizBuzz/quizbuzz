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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.annotation.JsonFormat;

import quiz.models.Answers;
import quiz.services.AnswersManager;

@RestController
@RequestMapping(path = "answer")
public class AnswerController {

	@Autowired
	private AnswersManager answer;
		
	
	@GetMapping(path = "/{id}", produces = "application/json")
	public List<Answers> findById(@PathVariable int id) {
		return answer.findAll(id);
	}


	private static final Logger log = LogManager.getLogger(TagsController.class);
	// Create logger for debugging 
	
	@GetMapping(path ="/testresults",produces = "application/json")
	public List<Answers> getAllAnswers() {
		log.info("Listing Answers");
		return this.answer.findAllAnswers();
	} //Getting Answers to compare with the front end

	@PostMapping(consumes = "application/json", produces = "application/json")
	public Answers create(@RequestBody Answers ans) {
		return answer.create(ans);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@PostMapping(path = "/answerstoquestion", consumes = "application/json", produces = "application/json")
	public List<Answers> createAnswers(@RequestBody List<Answers> answers){
		System.out.println(answers.get(0).getAnswer());
		System.out.println(answers.get(0).getAnswerId());
		System.out.println(answers.get(0).isCorrect());
//		System.out.println(answers.get(0).getQuestion());
//		answer.createAnswers(answers);
//		return null;
		return answer.createAnswers(answers);
	}

}
