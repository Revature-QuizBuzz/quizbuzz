package quiz.services;

import quiz.models.Tags;

import java.util.List;

public interface TagsManager {

    List<Tags> getAllTags();

    Tags createTag(String name);

    List<Tags> createTags(List<String> name);

}
