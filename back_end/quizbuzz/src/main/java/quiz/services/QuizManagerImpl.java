package quiz.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz.dao.*;
import quiz.models.*;

import java.util.Collections;
import java.util.List;

@Service
public class QuizManagerImpl implements QuizManager {

    @Autowired
    private QuizDAO daoQuiz;
    @Autowired
    private UserDAO daoUser;
    @Autowired
    private ScoresDAO daoScore;
    @Autowired
    private QuestionDAO daoQuestion;
    @Autowired
    private QuizTagDAO daoQuizTag;


    public Quiz create(Quiz quiz){
        User user = daoUser.findById(quiz.getUser().getId()).get();
        quiz.setUser(user);
        List<Question> questions = daoQuestion.findAllByQuizId(quiz.getId());
        quiz.setQuestions(questions);
        List<Scores> scores = daoScore.findAllByQuizId(quiz.getId());
        quiz.setScores(scores);
        List<QuizTag> tags = daoQuizTag.findAllByQuizId(quiz.getId());
        quiz.setTags(tags);
        return daoQuiz.save(quiz);
    }

    @Override
    public List<Quiz> findAll() {
        return daoQuiz.findAll();
    }

}
