package business;

import java.util.List;

import models.User;

public interface IBusUser {
	
	public void insertUser (User user) throws Exception;
	
	public void updateUser (User user) throws Exception;
	
	public void deleteUser (User user) throws Exception;
	
	public List<User> listUser() throws Exception;
	
	public boolean verifyUserLogin(User user) throws Exception;

}
