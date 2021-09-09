package quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import quiz.models.Quiz;
import quiz.services.QuizManager;

import java.util.List;

@RestController
@RequestMapping(path = "quiz")
public class QuizController {
    @Autowired
    private QuizManager manager;

    @PostMapping(path= "/createQuiz", produces = "application/json", consumes = "application/json")
    public Quiz create(@RequestBody Quiz quiz){
        return manager.create(quiz);
    }

    @GetMapping(produces = "application/json")
    public List<Quiz> getAll(){
        return manager.findAll();
    }
}
