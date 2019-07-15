package business;

import java.util.List;

import models.Phone;
import models.User;

public class Facade implements IBusUser, IBusPhone{

	@Override
	public void insertPhone(Phone phone) throws Exception {
		new BusPhone().insertPhone(phone);;
	}

	@Override
	public void updatePhone(Phone phone) throws Exception {
		new BusPhone().updatePhone(phone);
	}

	@Override
	public void deletePhone(Phone phone) throws Exception {
		new BusPhone().deletePhone(phone);
	}

	@Override
	public List<Phone> listPhones(Integer user_id) throws Exception {
		return new BusPhone().listPhones(user_id);
	}

	@Override
	public void insertUser(User user) throws Exception {
		new BusUser().insertUser(user);;
	}

	@Override
	public void updateUser(User user) throws Exception {
		new BusUser().updateUser(user);
	}

	@Override
	public void deleteUser(User user) throws Exception {
		new BusUser().deleteUser(user);
	}

	@Override
	public List<User> listUser() throws Exception {
		return new BusUser().listUser();
	}

	@Override
	public boolean verifyUserLogin(User user) throws Exception {
		return new BusUser().verifyUserLogin(user);
	}

}
