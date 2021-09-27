package quiz.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import quiz.dao.TagsDAO;
import quiz.models.Tags;

@Service
public class TagsManagerImpl implements TagsManager{
	
	@Autowired
	private TagsDAO dao;
	
	@Override
	public List<Tags> getAllTags() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public ResponseEntity<Tags> createTags(Tags t) throws SQLException {
		dao.save(t);
		return new ResponseEntity<Tags>(t, HttpStatus.OK);
	}

	@Override
	public void deleteTags(int id) {
		dao.deleteById(id);
	}

}
