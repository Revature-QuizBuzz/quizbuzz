package quiz.services;

import java.util.List;

import org.springframework.stereotype.Service;

import quiz.models.TestClass;
@Service
public interface TestManager {
	
	
	 TestClass create(TestClass tc);

}
