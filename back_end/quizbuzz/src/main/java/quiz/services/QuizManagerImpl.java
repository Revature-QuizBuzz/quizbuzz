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
    public List<Quiz> findAll() {
        return daoQuiz.findAll();
    }

    @Override
    public Quiz getQuizById(int id) {return daoQuiz.getById(id);}

    @Override
    public Quiz updateQuiz(int quizId, Quiz quiz) {
        Quiz updatedQuiz = daoQuiz.getById(quizId);
        List<Integer> oldIds = Quiz.getListIds(updatedQuiz.getQuestions());
        List<Integer> newIds = Quiz.getListIds(quiz.getQuestions());
        
        for(Question inputQuestion: quiz.getQuestions()) {
        	inputQuestion.setQuiz(quiz);
        	for(Answers inputAnswer: inputQuestion.getAnswers()) {
        		inputAnswer.setQuestion(inputQuestion);
        	}
        }
        
        List<Integer> deletions = new ArrayList<Integer>();
        for(Integer id: oldIds) {
        	// if a question id is not present in the updated quiz call delete
        	if(!newIds.contains(id)) {
        		deletions.add(id);
        	}
        }
        qManager.deleteQuestionsById(deletions);
        
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
