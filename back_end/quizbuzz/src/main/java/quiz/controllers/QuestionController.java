package quiz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import quiz.models.Question;
import quiz.services.QuestionManager;



@RestController
@RequestMapping(path = "/questions")
@CrossOrigin(origins = "http://localhost:4200")
public class QuestionController {

	
	@Autowired
	private QuestionManager manager;
	

	@Autowired
	private QuestionManager qm;
	
	private static final Logger log = LogManager.getLogger(TagsController.class);
	
	
	@GetMapping(path ="/question",produces = "application/json")
	public List<Question> getAllAnswers() {
		log.info("Listing Answers");
		return this.qm.getAllQuestions();
	} //Getting Questions to compare UserAnswers
	
	@GetMapping(path = "/{id}", produces = "application/json")
	public List<Question> getProduct(@PathVariable int id) {
		return qm.findAll(id);
	}
	
	@PostMapping(path= "/new",consumes="application/json", produces="application/json")
	public Question create( @RequestBody Question ques){
//		System.out.println(ques.getQuiz().getId());
		qm.create(ques);
		return null;
	}
}
