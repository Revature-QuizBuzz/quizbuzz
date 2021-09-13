package quiz.services;

import org.springframework.http.ResponseEntity;

import quiz.models.Question;

public interface QuestionManager {

	public ResponseEntity<Question> createQuestion(Question question);

}
