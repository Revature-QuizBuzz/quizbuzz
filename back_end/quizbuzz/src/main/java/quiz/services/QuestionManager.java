package quiz.services;

import java.util.List;

import quiz.models.Question;

public interface QuestionManager {
	
	List<Question> findAll();
	
	Question create(Question ques);

    Question findByQuestion(String name);
}
