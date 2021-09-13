package quiz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quiz.models.Question;
import quiz.services.QuestionManager;



@RestController
@RequestMapping(path = "/questions")
@CrossOrigin(origins = "http://localhost:4200")
public class QuestionController {

	
	@Autowired
	private QuestionManager manager;
	
	
	@GetMapping(path = "/{id}", produces = "application/json")
	public List<Question> getProduct(@PathVariable int id) {
		return manager.findAll(id);
	}
}
