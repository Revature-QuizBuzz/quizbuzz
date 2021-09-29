package quiz.services;

import java.util.List;

import quiz.models.ScoreBoard;
import quiz.models.User;

public interface UserManager {
<<<<<<< HEAD
//
//
//	List<ScoreBoard> findScoreBoard();
=======



>>>>>>> main

	User findLogin(User user);
	User createAccount(User user);
	List<User> getUsers();
<<<<<<< HEAD
//	User findById(Integer id);
//	List<ScoreBoard> findScoreBoard();
=======
	User findById(int id);

	List<ScoreBoard> findScoreBoard();
	
	
>>>>>>> main
}
