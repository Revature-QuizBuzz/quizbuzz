package quiz;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import quiz.models.Tags;
import quiz.models.User;
import quiz.services.TagsManager;
import quiz.services.UserManager;

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
		ResponseEntity<Tags> newTag = manager.createTags(tag);
		assertNotEquals(newTag, null);
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
