package quiz.services;
import quiz.models.Scores;
import java.util.List;
import org.springframework.http.ResponseEntity;

import java.util.List;

import quiz.models.Scores;
import java.util.List;

public interface ScoresManager {
	List<Scores> findAll();
	Object save(Scores score);
	Scores create(Scores score);
	Scores newScore(Scores score);
	List<Scores> getMyScores(int id);

}
