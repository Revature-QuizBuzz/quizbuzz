package quiz.services;

import quiz.models.Scores;
import java.util.List;

public interface ScoresManager {
	
	List<Scores> findAll();

	Object save(Scores score);

	Scores create(Scores score);

	Scores newScore(Scores score);
	Scores addScore(Scores score);

	List<Scores> getMyScores(int id);

}
