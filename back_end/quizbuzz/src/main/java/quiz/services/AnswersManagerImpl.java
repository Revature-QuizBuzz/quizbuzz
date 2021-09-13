package quiz.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quiz.dao.AnswersDAO;
import quiz.models.Answers;

@Service
public class AnswersManagerImpl implements AnswersManager {
	
	@Autowired
	private AnswersDAO adao;

	@Override
	public List<Answers> getAllAnswers() {
		return StreamSupport.stream(adao.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}
	
//	@Override
//	public List<Answers> getAllAnswers() {
//		return adao.findAll();
//	}
//
//	@Override
//	public Answers findById(int id) {
//		return adao.findOne(id);
//	}
}
