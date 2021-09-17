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
