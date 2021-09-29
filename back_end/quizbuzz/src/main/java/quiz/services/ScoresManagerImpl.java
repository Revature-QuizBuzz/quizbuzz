package quiz.services;

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
	public Scores create(Scores score) {
		return score;
	}
<<<<<<< HEAD

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
<<<<<<< HEAD

=======
>>>>>>> main
=======

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
>>>>>>> TakeQuizzes
	
	@Override
	public Scores addScore(Scores us) {
		// Create User Results
		return dao.save(us);
	}

<<<<<<< HEAD
=======

<<<<<<< HEAD
>>>>>>> main
=======
//	@Override
//	public Scores findScore(Scores score) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	@Override
//	public List<Scores> getScores() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	@Override
//	public Scores findById(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public Answers findById(Answers ua) {
//		return StreamSupport.stream(adao.findById(), false)
//				.collect(Collectors.toList());
//	}
//	
//	@Override
//	public List<Question> findAllQuestions() {
//		return StreamSupport.stream(qdao.findAll().spliterator(), false)
//				.collect(Collectors.toList());
//	}
//
//	@Override
//	public Answers findById(int id) {
//		return adao.findById(Integer.valueOf(id));
//	}
//	
//
//	@Override
//	public Question findByQuestion(Question q) {
//		return qdao.findByQuestion(findByQuestion q));
//	}

>>>>>>> TakeQuizzes
}
