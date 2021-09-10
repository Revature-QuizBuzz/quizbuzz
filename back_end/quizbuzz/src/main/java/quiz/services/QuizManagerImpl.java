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

    @Override
    public Quiz create(Quiz quiz){
        return daoQuiz.save(quiz);
    }

    @Override
    public List<Quiz> findAll() {
        return daoQuiz.findAll();
    }

}
