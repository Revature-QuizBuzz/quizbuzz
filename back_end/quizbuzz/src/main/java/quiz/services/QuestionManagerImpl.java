package quiz.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz.dao.QuestionDAO;
import quiz.models.Answers;
import quiz.models.Question;

import java.util.List;

@Service
public class QuestionManagerImpl implements QuestionManager{

    private AnswersManager aManager;

    @Autowired
    private QuestionDAO daoQuestion;

    @Override
    public Question updateQuestion(int questionId, Question question) {
        Question updatedQuestion = daoQuestion.getById(questionId);

        // Find deleted answers on the updated question
        List<Integer> deletionsA = Question.findAnswerDeletions(updatedQuestion.getAnswers(), question.getAnswers());
        // Call deleteAllByIdInBatch() to remove from database
        aManager.deleteAnswersById(deletionsA);
        // Update remaining answers
        for (Answers answer: question.getAnswers()) {
            aManager.updateAnswer(answer.getId(), answer);
        }
        // updatedQuestion.setAnswers(question.getAnswers());

        updatedQuestion.setQuestion(question.getQuestion());
        updatedQuestion.setPossiblePoints(question.getPossiblePoints());
        updatedQuestion.setType(question.getType());

        return daoQuestion.save(updatedQuestion);
    }

    @Override
    public void deleteQuestionsById(List<Integer> questionIds) {
        daoQuestion.deleteAllById(questionIds);
    }

}
