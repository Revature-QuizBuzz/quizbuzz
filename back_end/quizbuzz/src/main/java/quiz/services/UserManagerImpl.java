package quiz.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quiz.dao.UserDAO;
import quiz.models.ScoreBoard;
import quiz.models.User;

@Service
public class UserManagerImpl implements UserManager{

	@Autowired
	UserDAO userDao;
	
//	@Override
//	public List<ScoreBoard> findScoreBoard() {
//		return userDao.findScoreBoard();
//	}

//	@Override
//	public List<Object> findScoreBoard() {
//		return userDao.findScoreBoard();
//	}

//	@Override
//	public List<ScoreBoard> findById(int id) {
//		return userDao.findById(id);
//	}

	@Override
	public List<ScoreBoard> findScoreBoard() {
		// TODO Auto-generated method stub
		return userDao.findScoreBoard();
	}

	

}
