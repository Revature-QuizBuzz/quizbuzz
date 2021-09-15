package quiz.services;

import quiz.models.Answers;

import java.util.List;

public interface AnswersManager {

    Answers updateAnswer(int answerId, Answers answer);

    void deleteAnswersById(List<Integer> answerIds);

}
