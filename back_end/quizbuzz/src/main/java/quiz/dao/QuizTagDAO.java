package quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import quiz.models.QuizTag;

@Repository
public interface QuizTagDAO extends JpaRepository<QuizTag, Integer>{

}
