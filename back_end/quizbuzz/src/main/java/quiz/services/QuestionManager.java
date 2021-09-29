package quiz.services;

import java.util.List;

import quiz.models.Question;

public interface QuestionManager {
	
	List<Question> findAll();
	List<Question> createAll(List<Question> questions);
<<<<<<< HEAD
	Question create(Question ques);	
	List<Question> findAll(int id);
	List<Question> getAllQuestions();


    Question findByQuestion(String name);

=======
	Question create(Question ques);

    Question findByQuestion(String name);

	List<Question> findAll(int id);
	List<Question> getAllQuestions();
	
>>>>>>> main
}
