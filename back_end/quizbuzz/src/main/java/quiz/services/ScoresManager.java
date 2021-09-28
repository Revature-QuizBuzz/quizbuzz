package quiz.services;
import quiz.models.Scores;
import java.util.List;
import org.springframework.http.ResponseEntity;
import quiz.models.Answers;

import java.util.List;

import quiz.models.Scores;

public interface ScoresManager {
	
	List<Scores> findAll();

	Object save(Scores score);

	Scores create(Scores score);

	Scores newScore(Scores score);
	Scores addScore(Scores score);
//	Scores findById(int id);

}
