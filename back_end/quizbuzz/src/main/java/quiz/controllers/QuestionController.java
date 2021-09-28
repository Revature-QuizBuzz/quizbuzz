package quiz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quiz.models.Question;
import quiz.services.QuestionManager;

@RestController
@RequestMapping(path = "/questions")
public class QuestionController {

	@Autowired
	private QuestionManager manager;
	
	@GetMapping(path="/pull", produces = "application/json")
	public List<Question> getAllQuestions(){
		return manager.findAll();
	}
	
	@PostMapping(path= "/new",consumes="application/json", produces="application/json")
	public Question create( @RequestBody Question ques){
//		System.out.println(ques.getQuiz().getId());
		manager.create(ques);
		return null;
		
	}
	
	
	
	

}
