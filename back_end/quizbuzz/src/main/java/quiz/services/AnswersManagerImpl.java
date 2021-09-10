package quiz.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quiz.dao.AnswersDAO;
import quiz.models.Answers;
import quiz.models.Quiz;

@Service
public class AnswersManagerImpl implements AnswersManager {

	@Autowired
	private AnswersDAO dao;
	

	@Override
	public List<Answers> findAllAnswers() {
		return StreamSupport.stream(dao.findAll().spliterator(), false).collect(Collectors.toList());
	}

	@Override
	public Answers create(Answers ans) {
		return dao.save(ans);
	}

	public List<Answers> createAnswers(List<Answers> list) {
		return dao.saveAll(list);
	}

}
