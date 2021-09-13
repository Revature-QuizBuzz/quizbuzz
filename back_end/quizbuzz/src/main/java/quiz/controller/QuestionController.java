package quiz.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quiz.models.Question;
import quiz.services.QuestionManager;

@RestController
@RequestMapping(path="/questions")
public class QuestionController {
	
	@Autowired
	private QuestionManager manager;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path="/createquestion", consumes="application/json", produces="application/json")
	public ResponseEntity<Question> createQuestion(@RequestBody Question question){
		manager.createQuestion(question);
		return new ResponseEntity<Question>(question,HttpStatus.OK);
	}

}
