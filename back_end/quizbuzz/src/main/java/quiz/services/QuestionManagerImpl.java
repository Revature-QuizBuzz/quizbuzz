package quiz.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import quiz.dao.QuestionDAO;
import quiz.models.Question;

@Service
public class QuestionManagerImpl implements QuestionManager{

	@Autowired
	private QuestionDAO dao;
	
	@Override
	public ResponseEntity<Question> createQuestion(Question question){
		dao.save(question);
		return null;
	}
}
