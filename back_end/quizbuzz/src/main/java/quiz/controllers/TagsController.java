package quiz.controllers;

import java.sql.SQLException;
import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import quiz.models.Tags;
import quiz.services.TagsManager;


@RestController
@RequestMapping(path="/tags")
public class TagsController {
	
	@Autowired
	private TagsManager manager;

	private static final Logger logger = LogManager.getLogger(TagsController.class);
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping(path="", produces="application/json")
	public ResponseEntity<List<Tags>> getAllTags() {
		List<Tags> tagsList = manager.getAllTags();
		logger.info("GET to /tags");
		return new ResponseEntity<List<Tags>>(tagsList, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path="/new", consumes="application/json", produces="application/json")
	public ResponseEntity<Tags> createTags(@RequestBody Tags t) throws SQLException {
		ResponseEntity<Tags> returnTag;
		try {		
			manager.createTags(t);
			logger.info("POST to /tags/new");
			returnTag =  new ResponseEntity<Tags>(t, HttpStatus.OK);
		}	catch (SQLException e) {
			returnTag =  new ResponseEntity<Tags>(t, HttpStatus.CONFLICT);
		} 
		return returnTag;		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Integer> deleteTags(@PathVariable("id") Integer t) throws SQLException {
		ResponseEntity<Integer> returnTag;
		try {
			manager.deleteTags(t);
			logger.info("DELETE from /tags/{id}");
			returnTag = new ResponseEntity<Integer>(t, HttpStatus.OK);
		} catch (SQLException e) {
			returnTag = new ResponseEntity<Integer> (t, HttpStatus.CONFLICT);
		}
		return returnTag;
	}
		
}
