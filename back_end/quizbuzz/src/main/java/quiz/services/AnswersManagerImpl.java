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
	private AnswersDAO adao;

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

	@Override
	public List<Answers> createAnswers(List<Answers> allAnswers) {
		return dao.saveAll(allAnswers);
	}

	@Override
	public Answers findByAnswer(String answer) {
		return dao.findByAnswer(answer);
	}

	@Override
	public List<Answers> findAll(int id) {
		return dao.findAll();
	}
	@Override
	public List<Answers> getAllAnswers() {
		return StreamSupport.stream(adao.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}
	
<<<<<<< HEAD
	

	@Override
	public List<Answers> findAllAnswers() {
		return StreamSupport.stream(adao.findAll().spliterator(), false).collect(Collectors.toList());
	}


	@Override
	public Answers create(Answers ans) {
		return adao.save(ans);
	}

	public List<Answers> createAnswers(List<Answers> list) {
		return adao.saveAll(list);
	}

	@Override
	public Answers findByAnswer(String answer) {
		return adao.findByAnswer(answer);
	}
=======
//	@Override
//	public List<Answers> getAllAnswers() {
//		return adao.findAll();
//	}
//
//	@Override
//	public Answers findById(int id) {
//		return adao.findOne(id);
//	}
>>>>>>> main
}
