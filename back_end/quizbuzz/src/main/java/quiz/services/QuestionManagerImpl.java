package quiz.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz.dao.QuestionDAO;
//import quiz.models.Answers;
import quiz.models.Question;

import java.util.List;

@Service
public class QuestionManagerImpl implements QuestionManager{

    @Autowired
    private QuestionDAO daoQuestion;
    
//    @Autowired
//    private AnswersManager aManager;
    
    private static final Logger logger = LogManager.getLogger(QuestionManagerImpl.class);

    @Override
    public Question updateQuestion(int questionId, Question question) {
        Question updatedQuestion = daoQuestion.getById(questionId);
//
//        // Find deleted answers on the updated question
//        List<Integer> deletionsA = Question.findAnswerDeletions(updatedQuestion.getAnswers(), question.getAnswers());
//        // Check for new Answers
//        List<Answers> additionsA = Question.findNewAnswers(updatedQuestion.getAnswers(), question.getAnswers());
//        // create the newly added answers
//        if(!additionsA.isEmpty()) {
//        	aManager.createAll(additionsA);
//        }
//        // Call deleteAllByIdInBatch() to remove from database
//        if(!deletionsA.isEmpty()) {
//        	aManager.deleteAnswersById(deletionsA);
//        }
//        // Update remaining answers
//        for (Answers answer: question.getAnswers()) {
//            aManager.updateAnswer(answer.getId(), answer);
//        }
//        // updatedQuestion.setAnswers(question.getAnswers());
        
        updatedQuestion.setAnswers(question.getAnswers());
        updatedQuestion.setQuestion(question.getQuestion());
        updatedQuestion.setPossiblePoints(question.getPossiblePoints());
        updatedQuestion.setType(question.getType());

        return daoQuestion.save(updatedQuestion);
    }
    
    @Override
    public void createAll(List<Question> questions) {
    	daoQuestion.saveAll(questions);
    } 

    @Override
    public void deleteQuestionsById(List<Integer> questionIds) {
    	logger.info("Calling delete questions...");
    	logger.info("deleted ids are: " + questionIds);
        daoQuestion.deleteAllById(questionIds);
    }
    
    @Override
    public void deleteQuestion(Question question) {
    	daoQuestion.delete(question);
    }

}
