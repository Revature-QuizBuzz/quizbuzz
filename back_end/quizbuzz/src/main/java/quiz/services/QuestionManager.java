package quiz.services;

import quiz.models.Question;

import java.util.List;

public interface QuestionManager {
	
	List<Question> findAll();
	List<Question> createAll(List<Question> questions);
	Question create(Question ques);

    Question updateQuestion(int questionId, Question question);

    void deleteQuestionsById(List<Integer> questionIds);

    Question findByQuestion(String name);
}
