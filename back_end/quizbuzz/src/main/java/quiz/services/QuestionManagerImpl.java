package quiz.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz.dao.QuestionDAO;
import quiz.models.Question;

@Service
public class QuestionManagerImpl implements QuestionManager{

    @Autowired
    private QuestionDAO daoQuestion;

    @Override
    public Question updateQuestion(int questionId, Question question) {
        Question updatedQuestion = daoQuestion.getById(questionId);

        // [todo] for answer in answers update fields (create, then call the answer service)
        // updatedQuestion.setAnswers(question.getAnswers());

        updatedQuestion.setQuestion(question.getQuestion());
        updatedQuestion.setPossiblePoints(question.getPossiblePoints());
        updatedQuestion.setType(question.getType());

        return daoQuestion.save(updatedQuestion);
    }

}
