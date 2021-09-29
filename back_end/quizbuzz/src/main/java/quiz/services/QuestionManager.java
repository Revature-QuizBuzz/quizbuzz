package quiz.services;

import quiz.models.Question;

import java.util.List;

public interface QuestionManager {
	
	List<Question> findAll();
	List<Question> createAll(List<Question> questions);
	Question create(Question ques);

    Question updateQuestion(int questionId, Question question);

    void deleteQuestionsById(List<Integer> questionIds);
    
    void createAll(List<Question> questions);
    
    void deleteQuestion(Question question);

    Question findByQuestion(String name);
}
