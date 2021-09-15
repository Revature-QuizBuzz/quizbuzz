package quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import quiz.models.Quiz;
import quiz.models.Tags;
import quiz.models.User;

import java.util.List;

@Repository
public interface QuizDAO extends JpaRepository<Quiz, Integer>{
    List<Quiz> findAll();
    Quiz findById(int id);

    @Query("SELECT q FROM Quiz q WHERE q.user.id = ?1")
    List<Quiz> findByUserId(int userId);

    @Query("SELECT q FROM Quiz q WHERE q.tags = ?1")
    List<Quiz> findAllByTags(Tags tags);
}
