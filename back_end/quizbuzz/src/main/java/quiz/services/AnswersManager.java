package quiz.services;

import java.util.List;

import quiz.models.Answers;

public interface AnswersManager {

	List<Answers> findAllAnswers();

	Answers create(Answers ans);

	List<Answers> createAnswers(List<Answers> allAnswers);

}
