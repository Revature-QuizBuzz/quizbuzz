package quiz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quiz.models.User;
import quiz.models.Quiz;
import quiz.models.QuizTag;
import quiz.models.Tags;
import quiz.services.QuizTagManager;
import quiz.services.UserManager;

@RestController
@RequestMapping(path="/login")
public class LoginController {
	
	@Autowired
	private UserManager userManager;
	
	@Autowired
	private QuizTagManager quizTagManager;
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping(path="", consumes="application/json", produces="application/json")
	public ResponseEntity<User> login(@RequestBody User user) {
		System.out.println(user.getTotalPoints());
		return new ResponseEntity<>(userManager.findLogin(user), HttpStatus.CREATED);
	}
	
	@PostMapping(path="/createAccount", consumes="application/json", produces="application/json")
	public ResponseEntity<User> createAccount(@RequestBody User user) {
		return new ResponseEntity<>(userManager.createAccount(user), HttpStatus.CREATED);
	}
	
	@GetMapping(path="", produces="application/json")
	public ResponseEntity<List<User>> getUsers() {
		return new ResponseEntity<>(userManager.getUsers(), HttpStatus.OK);
	}
	
	@PostMapping(path="/addQuizTags", consumes="application/json", produces="application/json")
	public ResponseEntity<List<QuizTag>> addQuizTags(@RequestBody Quiz quiz) {
		List<QuizTag> tags = quizTagManager.makeQuizTags(quiz);
		return new ResponseEntity<>(tags, HttpStatus.CREATED);
	}
	
	@GetMapping(path="/addQuizTags", produces="application/json")
	public ResponseEntity<List<Tags>> getTags(@RequestBody Quiz quiz) {
		List<Tags> tags = quizTagManager.getTags(quiz);
		return new ResponseEntity<>(tags, HttpStatus.OK);
	}
}
