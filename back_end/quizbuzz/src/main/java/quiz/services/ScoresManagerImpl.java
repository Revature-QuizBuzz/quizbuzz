package quiz.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quiz.dao.ScoresDAO;
import quiz.models.Scores;

@Service
public class ScoresManagerImpl implements ScoresManager{
	
	@Autowired
	private ScoresDAO dao;
	
	// Finds all scores
	@Override
	public List<Scores> findAll() {
		return dao.findAll();
	}

	@Override
	public Scores create(Scores score) {
		return score;
	}

	@Override
	public Object save(Scores score) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Scores newScore(Scores score) {
		// TODO Auto-generated method stub
		return dao.save(score);
	}

}
