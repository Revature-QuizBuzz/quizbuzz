package quiz.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import quiz.dao.TagsDAO;
import quiz.models.Tags;

import java.util.ArrayList;
import java.util.List;

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
	public ResponseEntity<Integer> deleteTags(Integer t) throws SQLException {
		dao.deleteById(t);
		return new ResponseEntity<Integer>(t, HttpStatus.OK);
	}

	@Override
	public Tags findByName(String name) {
		return dao.findByName(name);
	}


    @Autowired
    TagsDAO daoTags;

    @Override
    public List<Tags> getAllTags() {
        List<Tags> tags = daoTags.findAll();
        return tags;
    }

    @Override
    public Tags createTag(String name) {
        Tags newTag = new Tags();
        newTag.setName(name);
        return daoTags.save(newTag);
    }
    
    @Override
    public Tags getTagByName(String name) {
    	return daoTags.findByName(name);
    }

    @Override
    public List<Tags> createTags(List<String> names) {
        List<Tags> newTags = new ArrayList<>();
        List<Tags> oldTags = getAllTags();
        
        for(String name: names) {
        	if(!oldTags.contains(getTagByName(name))) {
        		Tags newTag = createTag(name);
        		newTags.add(newTag);
        	}
        }
        return newTags;
    }
}
