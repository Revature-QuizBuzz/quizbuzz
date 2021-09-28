package quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import quiz.models.TestClass;


	
@Repository
public interface TestDAO extends JpaRepository<TestClass, Integer>{

		

}
