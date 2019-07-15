package business;

import java.util.List;

import dao.DaoUser;
import dao.IDaoUser;
import models.User;

public class BusUser implements IDaoUser {

	private final DaoUser daoUser = new DaoUser();

	public boolean verifyBasicData(User user) throws Exception {

		if (user == null) {
			throw new Exception("Error - Please enter with a user !");
		}

		if ((user.getName() == null) || (user.getName().equals(""))) {
			throw new Exception("Error - Enter a name !");
		}

		if (user.getName().trim().length() > 50) {
			throw new Exception("Error - Enter a name with until 50 characters !");
		}

		if ((user.getEmail() == null) || (user.getEmail().isEmpty() == true)
				|| (user.getEmail().trim().isEmpty() == true)) {
			throw new Exception("Error - Enter a email !");
		}

		if (user.getEmail().trim().length() > 50) {
			throw new Exception("Error - Enter a email with until 50 characters !");
		}

		if ((user.getPassword() == null) || (user.getPassword().isEmpty() == true)
				|| (user.getPassword().trim().isEmpty() == true)) {
			throw new Exception("Error - Enter the Password !");
		}

		if (user.getPassword().trim().length() != 8) {
			throw new Exception("Error - The Password must have 8 characters !");
		}

		return true;

	}

	@Override
	public void insertUser(User user) throws Exception {
		try {
			if (verifyBasicData(user)) {
				daoUser.inserUser(user);
			}

		} 
		catch (Exception exception) {
			throw exception;
		}

	}

	@Override
	public void updateUser(User user) throws Exception {
		try {
			if (verifyBasicData(user)) {
				daoUser.updateUser(user);
			}
			
		} 
		catch (Exception exception) {
			throw exception;
		}
	}

	@Override
	public void deleteUser(User user) throws Exception {
		try {
			if(verifyBasicData(user)) {
				daoUser.deleteUser(user);
			}
			
		} catch (Exception exception) {
			throw exception;
		}
	}

	@Override
	public List<User> listUser() throws Exception {
		try {
			return daoUser.listUser();
		} catch (Exception exception) {
			throw exception;
		}
	
	}

	@Override
	public boolean verifyUserLogin(User user) throws Exception {
		try {
			return daoUser.verifyUserLogin(user);
		} catch (Exception exception) {
			throw exception;
		}
	}
	
}
