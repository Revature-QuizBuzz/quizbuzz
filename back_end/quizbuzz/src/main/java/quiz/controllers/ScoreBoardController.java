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
		//re-factored print statements to logger
		logger.info("sort: " + sort);

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
		return scoreboard;
	}


}
