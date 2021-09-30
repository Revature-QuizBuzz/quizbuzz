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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz.dao.*;
import quiz.models.*;


import java.util.List;

@Service
public class QuizManagerImpl implements QuizManager {

    @Autowired
    private QuizDAO daoQuiz;
    
    private static final Logger logger = LogManager.getLogger(QuizManagerImpl.class);
    
    @Autowired
    private QuestionManager qManager;

    @Override
    public Quiz create(Quiz quiz){
        return daoQuiz.save(quiz);
    }

    @Override
    public List<Quiz> findAll() {
        return daoQuiz.findAll();
    }
    
    
    @Override
	public void deleteQuiz(Integer quizId) {
		daoQuiz.deleteById(quizId);
	}

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
	public List<Quiz> findByQuizName(String quizName) {
		return daoQuiz.findByQuizName(quizName);
	}

	@Override
	public List<Quiz> getFeaturedQuizzes() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Quiz findByUserAndQuizName(Integer userId, String quizName) {
		return daoQuiz.findByUserAndQuizName(userId, quizName);
	}

}
