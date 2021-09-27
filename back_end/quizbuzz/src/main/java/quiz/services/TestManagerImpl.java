package quiz.services;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import quiz.dao.TestDAO;
import quiz.models.TestClass;
@Service
public class TestManagerImpl implements TestManager{
	
	@Autowired
	private TestDAO dao;

	
	
	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE, rollbackFor = {
			ConstraintViolationException.class }, propagation = Propagation.REQUIRES_NEW) 
	public TestClass create(TestClass tc) {
		return dao.save(tc);
	}

}
