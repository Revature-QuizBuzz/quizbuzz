package quiz.controllers;

import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quiz.models.Tags;
import quiz.services.TagsManager;


@RestController
@RequestMapping(path="/tags")
public class TagsController {
	
	@Autowired
	private TagsManager manager;

	private static final Logger logger = LogManager.getLogger(TagsController.class);
	
	
//	@GetMapping(path="", produces="application/json")
//	public ResponseEntity<List<Tags>> getAllTags() {
//		//List<Tags> tagsList = 		
//		return new ResponseEntity<List<Tags>>(tagslist, HttpStatus.OK);
//	}
//	@CrossOrigin(origins = "http://localhost:4200")
//	@PostMapping(path="/new",consumes="application/json", produces="application/json")//adds new tag to db
//	public ResponseEntity<Tags> createTags(@RequestBody Tags t) {
//		System.out.println(t.getName());
//		manager.createTags(t);
//		logger.info("New Tag Created");
//		return new ResponseEntity<Tags>(t,HttpStatus.OK);
//	}
	
}
