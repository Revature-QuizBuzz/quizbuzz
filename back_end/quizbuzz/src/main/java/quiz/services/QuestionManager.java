package quiz.services;

import quiz.models.Question;

public interface QuestionManager {

    Question updateQuestion(int questionId, Question question);

}
