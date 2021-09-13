package quiz.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quiz.dao.AnswersDAO;
import quiz.models.Answers;



@Service
public class AnswersManagerImpl implements AnswersManager {

	
	@Autowired
	private AnswersDAO dao;
	
	@Override
	public List<Answers> findAll(int id) {
		return dao.findAll();
	}
}
