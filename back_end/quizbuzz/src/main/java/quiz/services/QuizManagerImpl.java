package quiz.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quiz.dao.QuizDAO;
import quiz.models.Answers;
import quiz.models.Question;
import quiz.models.Quiz;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class QuizManagerImpl implements QuizManager {

    @Autowired
    private QuizDAO daoQuiz;
    
    private static final Logger logger = LogManager.getLogger(QuizManagerImpl.class);
    
    @Autowired
    private QuestionManager qManager;
//    
//    @Autowired
//    private TagsManager tagManager;

    @Override
    public Quiz create(Quiz quiz){
        return daoQuiz.save(quiz);
    }

//    @Override
//    public Quiz findById(int id) {
//        return daoQuiz.findById(id);
//    }

    @Override
    public List<Quiz> findAll() {
        return daoQuiz.findAll();
    }
    
//    @Override
//    public List<Quiz> getFeaturedQuizzes() {
//    	return daoQuiz.getFeaturedQuizzes();
//    }

    @Override
    public List<Quiz> findByUser(int userId) {
        return daoQuiz.findByUserId(userId);
    }

    @Override
    public Quiz findByName(String name) {
        return daoQuiz.findByName(name);
    }

    @Override
    public Quiz getQuizById(int id) {
    	System.out.println(daoQuiz.getById(id).getName());
    	return daoQuiz.findById(id).get();
    }

    @Override
    public Quiz updateQuiz(int quizId, Quiz quiz) {
        Quiz updatedQuiz = daoQuiz.getById(quizId);

        
        for(Question inputQuestion: quiz.getQuestions()) {
        	inputQuestion.setQuiz(quiz);
        	for(Answers inputAnswer: inputQuestion.getAnswers()) {
        		inputAnswer.setQuestion(inputQuestion);
        	}
        }
        
        // update questions
        updatedQuiz.setQuestions(quiz.getQuestions());
        
        //update tags so service returns the updated object
        updatedQuiz.setTags(quiz.getTags());

        updatedQuiz.setName(quiz.getName());

        updatedQuiz.setDescription(quiz.getDescription());

        // calculate totalScore
        int updatedScore = quiz.calculateTotalScore(quiz.getQuestions());
        updatedQuiz.setTotalScore(updatedScore);

        updatedQuiz.setDateModified(new Date());
        
        return daoQuiz.save(updatedQuiz);
    }
}