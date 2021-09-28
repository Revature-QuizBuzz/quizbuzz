package quiz.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz.dao.ScoresDAO;
import quiz.models.Scores;

@Service
public class ScoresManagerImpl implements ScoresManager{

	@Autowired
	private ScoresDAO sdao;

	
	@Override
	public Scores addScore(Scores us) {
		// Create User Results
		return sdao.save(us);
	}


}
