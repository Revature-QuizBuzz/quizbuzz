package quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quiz.models.Quiz;
import quiz.services.QuizManager;

@RestController
@RequestMapping(path = "quiz")
public class QuizController {
    @Autowired
    private QuizManager manager;

    @PostMapping(path= "/createQuiz", produces = "application/json", consumes = "application/json")
    public Quiz create(@RequestBody Quiz quiz){
        return manager.create(quiz);
    }
}
