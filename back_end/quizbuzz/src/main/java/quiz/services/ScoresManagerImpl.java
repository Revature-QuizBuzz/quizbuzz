package quiz.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz.dao.AnswersDAO;
import quiz.dao.QuestionDAO;
import quiz.dao.ScoresDAO;
import quiz.models.Answers;
import quiz.models.Question;
import quiz.models.Scores;

@Service
public class ScoresManagerImpl implements ScoresManager{
	
	@Autowired
	private AnswersDAO adao;
	@Autowired
	private ScoresDAO sdao;

	@Override
	public List<Answers> findAll() {
		return StreamSupport.stream(adao.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}
	
	@Override
	public Scores addScore(Scores us) {
		// Create User Results
		return sdao.save(us);
	}

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

}
