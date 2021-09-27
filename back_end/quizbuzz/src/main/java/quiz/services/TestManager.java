package quiz.services;

import org.springframework.stereotype.Service;

import quiz.models.TestClass;
@Service
public interface TestManager {
	
	
	 TestClass create(TestClass tc);

}
