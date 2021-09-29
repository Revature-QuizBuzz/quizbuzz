package quiz.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz.dao.AnswersDAO;
import quiz.models.Answers;

import java.util.List;

import quiz.dao.AnswersDAO;
import quiz.models.Answers;
import quiz.models.Quiz;

@Service
public class AnswersManagerImpl implements AnswersManager {

	@Autowired
	private AnswersDAO dao;
	

	@Override
	public List<Answers> findAllAnswers() {
		return StreamSupport.stream(dao.findAll().spliterator(), false).collect(Collectors.toList());
	}

	@Override
	public Answers create(Answers ans) {
		return dao.save(ans);
	}

	public List<Answers> createAnswers(List<Answers> list) {
		return dao.saveAll(list);
	}

	@Override
	public Answers findByAnswer(String answer) {
		return dao.findByAnswer(answer);
	}

	@Override
    public Answers updateAnswer(int answerId, Answers answer) {
        Answers updatedAnswer = dao.getById(answerId);

        updatedAnswer.setAnswer(answer.getAnswer());
        updatedAnswer.setCorrect(answer.isCorrect());

        return dao.save(updatedAnswer);
    }
    
    @Override
    public void createAll(List<Answers> answers) {
    	dao.saveAll(answers);
    }

    @Override
    public void deleteAnswersById(List<Integer> answerIds) {
        dao.deleteAllByIdInBatch(answerIds);
    }

}
