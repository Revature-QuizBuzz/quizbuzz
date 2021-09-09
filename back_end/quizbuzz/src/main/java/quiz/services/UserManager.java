package quiz.services;

import quiz.models.User;

public interface UserManager {

	User findLogin(User user);
	User createAccount(User user);

}
