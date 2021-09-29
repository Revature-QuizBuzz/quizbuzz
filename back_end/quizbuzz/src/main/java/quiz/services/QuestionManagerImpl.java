package quiz.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz.dao.QuestionDAO;
import quiz.models.Answers;
import quiz.models.Question;

import java.util.List;

import quiz.dao.QuestionDAO;
import quiz.models.Question;

@Service
public class QuestionManagerImpl implements QuestionManager {

	@Autowired
	private QuestionDAO daoQuestion;
	
	@Autowired
    private AnswersManager aManager;

	
    private static final Logger logger = LogManager.getLogger(QuestionManagerImpl.class);

	@Override
	public List<Question> findAll() {
		return StreamSupport.stream(daoQuestion.findAll().spliterator(), false).collect(Collectors.toList());
	}

	@Override
	public Question create(Question que) {
		return daoQuestion.save(que);
	}

	@Override
	public List<Question> createAllPersisted(List<Question> questions) {
		List<Question> persistedQuestion = new ArrayList<Question>();
		for (Question question : questions) {
			persistedQuestion.add(daoQuestion.save(question));
		}
		return persistedQuestion;
	}

	public Question findByQuestion(String text) {
		return daoQuestion.findByQuestion(text);
	}
	
	@Override
	public List<Question> findAll(int id) {
		return dao.findAllByQuizId(id);
	}

	@Autowired
	private QuestionDAO qdao;
	
	@Override
	public List<Question> getAllQuestions() {
		return StreamSupport.stream(qdao.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}

    @Override
    public void createAll(List<Question> questions) {
    	daoQuestion.saveAll(questions);
    } 

	// @Override
	// public List<Question> createAll(List<Question> questions) {
	// 	List<Question> persistedQuestion = new ArrayList<Question>();
	// 	for (Question question : questions) {
	// 		persistedQuestion.add(daoQuestion.save(question));
	// 	}
	// 	return persistedQuestion;}
	// public Question findByQuestion(String text) {
	// 	return daoQuestion.findByQuestion(text);
	// }


    @Override
    public Question updateQuestion(int questionId, Question question) {
        Question updatedQuestion = daoQuestion.getById(questionId);

       // Find deleted answers on the updated question
       List<Integer> deletionsA = Question.findAnswerDeletions(updatedQuestion.getAnswers(), question.getAnswers());
       // Check for new Answers
       List<Answers> additionsA = Question.findNewAnswers(updatedQuestion.getAnswers(), question.getAnswers());
       // create the newly added answers
       if(!additionsA.isEmpty()) {
       	aManager.createAll(additionsA);
       }
       // Call deleteAllByIdInBatch() to remove from database
       if(!deletionsA.isEmpty()) {
       	aManager.deleteAnswersById(deletionsA);
       }
       // Update remaining answers
       for (Answers answer: question.getAnswers()) {
           aManager.updateAnswer(answer.getAnswerId(), answer);
       }
       // updatedQuestion.setAnswers(question.getAnswers());
        
        updatedQuestion.setAnswers(question.getAnswers());
        updatedQuestion.setQuestion(question.getQuestion());
        updatedQuestion.setPossiblePoints(question.getPossiblePoints());
        updatedQuestion.setType(question.getType());

        return daoQuestion.save(updatedQuestion);
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
