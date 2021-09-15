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

        // find deleted questions
        List<Integer> deletionsQ = Quiz.findQuestionDeletions(updatedQuiz.getQuestions(), quiz.getQuestions());
        // call question manager to delete from database
        qManager.deleteQuestionsById(deletionsQ);
        // update remaining questions, updateQuestion() calls updateAnswers()
        for(Question question: quiz.getQuestions()) {
            qManager.updateQuestion(question.getId(), question);
        }
        // update questions so that service returns the updated object
        updatedQuiz.setQuestions(quiz.getQuestions());

        // Look for tags that aren't on the quiz already
        List<String> createTags = Quiz.findTagCreations(updatedQuiz.getTags(), quiz.getTags());
        // compare createTags to database to see if they already exist, if not call create
        tagManager.createTags(createTags);
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
