package quiz;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import quiz.models.Tags;
import quiz.models.User;
import quiz.services.TagsManager;
import quiz.services.UserManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import quiz.dao.QuizDAO;
import quiz.models.Quiz;
import quiz.services.QuizManager;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class QuizbuzzApplicationTests {
	
	@Autowired
	private TagsManager manager;

	@Autowired
	private UserManager userManager;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void createTags(Tags tag) {
		ResponseEntity<Tags> newTag;
		try {
			newTag = manager.createTags(tag);
			assertNotEquals(newTag, null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void login() {
		User user = new User();
		user.setUsername("test");
		user.setPassword("1234");
		User found = userManager.findLogin(user);
		assertNotEquals(found, null);
	}
	
}
