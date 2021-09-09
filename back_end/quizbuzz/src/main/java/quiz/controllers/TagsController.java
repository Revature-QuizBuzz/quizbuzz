package quiz.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quiz.models.Tags;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path="/tags")
public class TagsController {

	private static final Logger logger = LogManager.getLogger(TagsController.class);
	
	
	@GetMapping(path="", produces="application/json")
	public ResponseEntity<List<Tags>> getAllTags() {
		//List<Tags> tagsList = 		
		return new ResponseEntity<List<Tags>>(tagslist, HttpStatus.OK);
	}
	
}
