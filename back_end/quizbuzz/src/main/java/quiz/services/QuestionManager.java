package quiz.services;

import quiz.models.Question;

import java.util.List;

public interface QuestionManager {

    Question updateQuestion(int questionId, Question question);

    void deleteQuestionsById(List<Integer> questionIds);

}
