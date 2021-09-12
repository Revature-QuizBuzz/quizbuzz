package quiz.services;
import quiz.models.Question;
import quiz.models.Scores;

import java.util.List;

import org.springframework.http.ResponseEntity;

import quiz.models.Answers;

public interface ScoresManager {
	
	List<Answers> findAll();
	
//	Answers findById(int id);

	Scores create(Scores us);

//	List<Answers>findByIdandQuestion(int id, Question question);

//	List<Question> findAllQuestions();
//
//	Question findByQuestion(Question q);
}
