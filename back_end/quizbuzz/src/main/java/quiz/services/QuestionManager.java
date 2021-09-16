package quiz.services;

import java.util.List;

import quiz.models.Question;

public interface QuestionManager {

	
	List<Question> findAll(int id);
	List<Question> getAllQuestions();

}
