package quiz;

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
	
//	 @Autowired
//	 private QuizManager quizManager;

	@Test
	void contextLoads() {
	}
	
//	@Test
//	public void test2() throws Exception {
//		assertThat(quizManager).isNotNull();
//	    System.out.println("quizManager is not null");
//	}

//	@Autowired
//	private QuizDAO quizDAO;
//	@Test
//	void create(){
//
//	}
//
//
//	@Test
//	void findById() {
//		//given
//		int id =1;
//
//		//when
//		Quiz expected = quizManager.findById(id);
//		//then
//		Assertions.assertThat(expected).isNotNull();
//	}

}
