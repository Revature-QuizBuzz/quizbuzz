package quiz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quiz.models.User;
import quiz.services.UserManager;

@RestController
@RequestMapping(path="/login")
public class LoginController {
	
	@Autowired
	private UserManager userManager;
	
	@PostMapping(path="", consumes="application/json", produces="application/json")
	public ResponseEntity<User> login(@RequestBody User user) {
		return new ResponseEntity<>(userManager.findLogin(user), HttpStatus.CREATED);
	}
	
	@PostMapping(path="/createAccount", consumes="application/json", produces="application/json")
	public ResponseEntity<User> createAccount(@RequestBody User user) {
		return new ResponseEntity<>(userManager.createAccount(user), HttpStatus.CREATED);
	}
}
