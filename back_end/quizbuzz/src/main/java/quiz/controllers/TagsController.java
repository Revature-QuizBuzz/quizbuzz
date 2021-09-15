package quiz.controllers;

import java.sql.SQLException;
import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	
	@GetMapping(path="", produces="application/json")
	public ResponseEntity<List<Tags>> getAllTags() {
		List<Tags> tagsList = manager.getAllTags();
		logger.info("GET to /tags");
		return new ResponseEntity<List<Tags>>(tagsList, HttpStatus.OK);
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path="/new",consumes="application/json", produces="application/json")
	public ResponseEntity<String> createTags(@RequestBody Tags t) throws SQLException {
		ResponseEntity<String> returnString;
		try {		
			manager.createTags(t);
			logger.info("POST to /tags/new");
			returnString =  new ResponseEntity<String>("success", HttpStatus.OK);
		}	catch (SQLException e) {
			// TODO Auto-generated catch block
			returnString =  new ResponseEntity<String>("failure", HttpStatus.I_AM_A_TEAPOT);
		}
		return returnString;
		
	}
		
}
