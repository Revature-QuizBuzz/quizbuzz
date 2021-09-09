package quiz;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import quiz.services.QuizManager;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class QuizbuzzApplicationTests {
	
	 @Autowired
	 private QuizManager manager;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void test2() throws Exception {
		assertThat(manager).isNotNull();
	    System.out.println("quizmanager is not null");
	}

}
