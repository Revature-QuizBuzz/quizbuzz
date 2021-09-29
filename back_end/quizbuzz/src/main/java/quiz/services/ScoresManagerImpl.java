package quiz.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz.dao.ScoresDAO;
import quiz.models.Scores;

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
	public Object save(Scores score) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Scores newScore(Scores score) {
		// TODO Auto-generated method stub
		return dao.save(score);
	}

	public Scores create(Scores us) {
		us.setCompletedOn( new Date());		
		return dao.save(us);
	}

	@Override
	public Scores addScore(Scores score) {
		// TODO Auto-generated method stub
		return dao.save(score);
	}

}
