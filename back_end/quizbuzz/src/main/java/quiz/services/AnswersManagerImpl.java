package quiz.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz.dao.AnswersDAO;
import quiz.models.Answers;

import java.util.List;

@Service
public class AnswersManagerImpl implements AnswersManager {

    @Autowired
    private AnswersDAO daoAnswers;

    @Override
    public Answers updateAnswer(int answerId, Answers answer) {
        Answers updatedAnswer = daoAnswers.getById(answerId);

        updatedAnswer.setAnswer(answer.getAnswer());
        updatedAnswer.setCorrect(answer.isCorrect());

        return daoAnswers.save(updatedAnswer);
    }

    @Override
    public void deleteAnswersById(List<Integer> answerIds) {
        daoAnswers.deleteAllByIdInBatch(answerIds);
    }
}
