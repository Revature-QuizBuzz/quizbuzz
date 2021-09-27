package quiz.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quiz.models.ScoreBoard;
import quiz.services.UserManager;

@RestController
@RequestMapping("/scoreboard")
public class ScoreBoardController {

	private static final Logger logger = LogManager.getLogger(ScoreBoardController.class);
	
	@Autowired
	private UserManager manager;

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(produces="application/json")
	public List<ScoreBoard> findScoreBoard() {
		logger.info("GET to /scoreboard");
		List<ScoreBoard> scoreboard = manager.findScoreBoard();
//		System.out.println(scoreboard);
		return scoreboard;
	}


}
