package quiz.services;

import java.util.List;

import quiz.models.Question;

public interface QuestionManager {
	
	List<Question> findAll();
	List<Question> createAll(List<Question> questions);
	Question create(Question ques);	
	List<Question> findAll(int id);
	List<Question> getAllQuestions();
    Question findByQuestion(String name);
    void delete(int questionId);
}
