package quiz.services;

<<<<<<< HEAD
<<<<<<< HEAD

=======
import java.util.ArrayList;
>>>>>>> TakeQuizzes
import java.util.List;
import java.util.stream.StreamSupport;
<<<<<<< HEAD
=======
>>>>>>> main
import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;
import java.util.stream.Collectors;
<<<<<<< HEAD
=======

import org.apache.el.stream.Optional;
>>>>>>> main
=======
import java.util.stream.Collectors;

import org.apache.el.stream.Optional;
>>>>>>> TakeQuizzes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz.dao.QuestionDAO;
import quiz.models.Question;
<<<<<<< HEAD
import quiz.dao.QuestionDAO;
import quiz.models.Question;



@Service
public class QuestionManagerImpl implements QuestionManager{
	
	@Autowired
	private QuestionDAO dao;
	
<<<<<<< HEAD
=======

	@Override
	public List<Question> findAll() {
		return StreamSupport.stream(dao.findAll().spliterator(), false).collect(Collectors.toList());
	}
	
	@Override
	public Question create(Question que) {
		return dao.save(que);
	}

	@Override
	public List<Question> createAll(List<Question> questions) {
		List<Question> persistedQuestion = new ArrayList<Question>();
		for (Question question : questions) {
			persistedQuestion.add(dao.save(question));
		}
		return persistedQuestion;}
	
	
	public Question findByQuestion(String text) {
		return dao.findByQuestion(text);
	}
	
>>>>>>> TakeQuizzes
	@Override
	public List<Question> findAll(int id) {
		return dao.findAllByQuizId(id);
	}

	@Autowired
	private QuestionDAO qdao;
	
	@Override
	public List<Question> getAllQuestions() {
		return StreamSupport.stream(qdao.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}
	
=======

@Service
public class QuestionManagerImpl implements QuestionManager {

	@Autowired
	private QuestionDAO dao;

>>>>>>> main
	@Override
	public List<Question> findAll() {
		return StreamSupport.stream(dao.findAll().spliterator(), false).collect(Collectors.toList());
	}

	@Override
	public Question create(Question que) {
		return dao.save(que);
	}

	@Override
	public List<Question> createAll(List<Question> questions) {
		List<Question> persistedQuestion = new ArrayList<Question>();
		for (Question question : questions) {
			persistedQuestion.add(dao.save(question));
			
		}
		return persistedQuestion;
	}

	public Question findByQuestion(String text) {
		return dao.findByQuestion(text);
<<<<<<< HEAD

=======
	}
	
	@Override
	public List<Question> findAll(int id) {
		return dao.findAllByQuizId(id);
	}

	@Autowired
	private QuestionDAO qdao;
	
	@Override
	public List<Question> getAllQuestions() {
		return StreamSupport.stream(qdao.findAll().spliterator(), false)
				.collect(Collectors.toList());
>>>>>>> main
	}

}
