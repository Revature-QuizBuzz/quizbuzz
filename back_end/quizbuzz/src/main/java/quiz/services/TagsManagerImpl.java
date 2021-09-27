package quiz.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz.dao.TagsDAO;
import quiz.models.Tags;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagsManagerImpl implements TagsManager{

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
