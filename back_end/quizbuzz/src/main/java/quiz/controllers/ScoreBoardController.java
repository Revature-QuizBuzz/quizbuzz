<<<<<<< HEAD
<<<<<<< HEAD
//package quiz.controllers;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import quiz.models.ScoreBoard;
//import quiz.services.UserManager;
//
//import java.util.Optional;
//
//
//@RestController
//@RequestMapping("/scoreboard")
//public class ScoreBoardController {
//
//	@Autowired
//	private UserManager manager;
//
//	@CrossOrigin(origins = "http://localhost:4200")
//	@GetMapping(produces="application/json")
//	public List<ScoreBoard> findScoreBoard() {
//		
//		List<ScoreBoard> scoreboard = manager.findScoreBoard();
//		System.out.println(scoreboard);
//		return scoreboard;
//	}
//
//
//}
=======
=======
>>>>>>> TakeQuizzes
package quiz.controllers;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.stream.Collectors;

import quiz.models.ScoreBoard;
import quiz.services.UserManager;

@RestController
@RequestMapping("/scoreboard")
public class ScoreBoardController {

	private static final Logger logger = LogManager.getLogger(ScoreBoardController.class);
	
	@Autowired
	private UserManager manager;

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path = "/{sort}", produces = "application/json")
	public List<ScoreBoard> findScoreBoard(@PathVariable String sort) {
		System.out.println("sort");
		System.out.println(sort);

		List<ScoreBoard> scoreboard = manager.findScoreBoard();
		List<ScoreBoard> sortedUsers = null;
		
		
		
			 sortedUsers = scoreboard.stream()
			 		  .sorted(Comparator.comparing(ScoreBoard::getTotalPoints).reversed())
			 		  .collect(Collectors.toList());
			
		
		return sortedUsers;
	}
	
	@GetMapping(produces="application/json")
	public List<ScoreBoard> findScoreBoard() {
		logger.info("GET to /scoreboard");
		List<ScoreBoard> scoreboard = manager.findScoreBoard();
//		System.out.println(scoreboard);
		return scoreboard;
	}


}
<<<<<<< HEAD
>>>>>>> main
=======
>>>>>>> TakeQuizzes
