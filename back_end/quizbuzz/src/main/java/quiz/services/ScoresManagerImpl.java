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
	
	// TODO: Validate score is valid (int)
	@Override
	public Scores newScore(Scores score) {
		return dao.save(score);
	}
	
}
