package quiz.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz.dao.QuestionDAO;
import quiz.models.Answers;
import quiz.models.Question;

import java.util.List;

import quiz.dao.QuestionDAO;
import quiz.models.Question;


@Service
public class QuestionManagerImpl implements QuestionManager{
	
	@Autowired
	private QuestionDAO dao;
	

	@Override
	public List<Question> findAll() {
		return StreamSupport.stream(dao.findAll().spliterator(), false).collect(Collectors.toList());
	}
	
	@Override
	public Question create(Question que) {
		return dao.save(que);
	}

	@Override
	public List<Question> createAll(List<Question> questions) {
		List<Question> persistedQuestion = new ArrayList<Question>();
		for (Question question : questions) {
			persistedQuestion.add(dao.save(question));
		}
		return persistedQuestion;}
	public Question findByQuestion(String text) {
		return dao.findByQuestion(text);
	}

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
