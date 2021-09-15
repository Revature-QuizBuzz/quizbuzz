package quiz.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz.dao.QuizDAO;
import quiz.models.Question;
import quiz.models.Quiz;

import quiz.models.Tags;
import quiz.services.QuizManager;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class QuizManagerImpl implements QuizManager {

    private QuestionManager qManager;
    private TagsManager tagManager;

    @Autowired
    private QuizDAO daoQuiz;

    @Override
    public List<Quiz> findAll() {
        return daoQuiz.findAll();
    }

    @Override
    public Quiz getQuizById(int id) {return daoQuiz.getById(id);}

    @Override
    @Transactional
    public Quiz updateQuiz(int quizId, Quiz quiz) {
        Quiz updatedQuiz = daoQuiz.getById(quizId);

        // [todo] refactor this so it's a method that takes an object and list of same type (in quiz model)
        // find deleted questions
        List<Integer> deletionsQ = Quiz.findQuestionDeletions(updatedQuiz.getQuestions(), quiz.getQuestions());
        // call question manager to delete from database
        qManager.deleteQuestionsById(deletionsQ);
        // update remaining questions, updateQuestion() calls updateAnswers()
        for(Question question: quiz.getQuestions()) {
            qManager.updateQuestion(question.getId(), question);
        }


        // update old tags
        /* [todo] look for new tags and call create tag if there are tags in the new one not present in the old */
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
