package quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import quiz.models.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer>{
    User findById(int id);

}
