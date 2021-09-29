package quiz.services;

import quiz.models.Question;

import java.util.List;

public interface QuestionManager {
	
	List<Question> findAll();
	void createAll(List<Question> questions);
	Question create(Question ques);

    Question updateQuestion(int questionId, Question question);

    void deleteQuestionsById(List<Integer> questionIds);
    
    List<Question> createAllPersisted(List<Question> questions);
    
    void deleteQuestion(Question question);

    Question findByQuestion(String name);
}
