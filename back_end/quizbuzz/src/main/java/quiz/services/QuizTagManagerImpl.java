package quiz.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quiz.dao.QuizDAO;
import quiz.dao.QuizTagDAO;
import quiz.models.Quiz;
import quiz.models.QuizTag;
import quiz.models.Tags;

@Service
public class QuizTagManagerImpl implements QuizTagManager{
	
	@Autowired
	private QuizTagDAO qtDao;
	
	@Autowired
	private QuizDAO qDao;
	
	@Override
	@Transactional
	public List<QuizTag> makeQuizTags(Quiz quiz) {
//		List<QuizTag> tags = quiz.getTags();
//		for(QuizTag tag: tags) {
//			qtDao.save(tag);
//		}
//		return qtDao.findAll();
		return null;
	}
	
	public List<Tags> getTags(Quiz quiz) {
		return (qDao.findById(quiz.getId())).get().getTags();
	}
}
