package quiz.services;

import java.util.List;

import quiz.models.User;

public interface UserManager {

	User findLogin(User user);
	User createAccount(User user);
	List<User> getUsers();
	User findById(int id);

}
