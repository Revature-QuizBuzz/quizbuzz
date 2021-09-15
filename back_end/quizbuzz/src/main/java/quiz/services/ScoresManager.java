package quiz.services;

import java.util.List;

import quiz.models.Scores;

public interface ScoresManager {
	
	List<Scores> findAll();

	Object save(Scores score);

	Scores create(Scores score);

	Scores newScore(Scores score);

}
