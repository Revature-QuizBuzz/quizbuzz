package quiz.services;
import quiz.models.Scores;
import java.util.List;
import org.springframework.http.ResponseEntity;
import quiz.models.Answers;

public interface ScoresManager {
	
	Scores addScore(Scores score);
//	Scores findById(int id);

}
