package quiz.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quiz.models.TestClass;
import quiz.services.TestManager;


@RestController
@RequestMapping(path = "/testanswers")
public class TestController {
	
	private static final Logger logger = LogManager.getLogger(TestController.class);
	
	@Autowired
	private TestManager manager; 
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
	public TestClass create(@Validated @RequestBody TestClass tc) {
		logger.info("POST to /create");
		return manager.create(tc);
	}


}
