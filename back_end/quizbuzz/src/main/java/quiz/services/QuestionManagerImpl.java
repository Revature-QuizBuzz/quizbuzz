package quiz.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz.dao.QuestionDAO;
import quiz.models.Question;


@Service
public class QuestionManagerImpl implements QuestionManager{
	
	@Autowired
	private QuestionDAO dao;
	
	
	@Override
	public List<Question> findAll(int id) {
		return dao.findAll();
	}

	@Autowired
	private QuestionDAO qdao;
	
	@Override
	public List<Question> getAllQuestions() {
		return StreamSupport.stream(qdao.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}

}
