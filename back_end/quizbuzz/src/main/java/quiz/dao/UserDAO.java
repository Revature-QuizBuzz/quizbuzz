package quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import quiz.models.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer>{

	@Query("select u from User u where u.username = :Username")
	User findLogin(@Param("Username")String username);

}
