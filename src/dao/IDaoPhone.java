package dao;

import java.util.List;

import models.Phone;

public interface IDaoPhone {

	public void insertPhone(Phone phone) throws Exception;

	public void updatePhone(Phone phone) throws Exception;

	public void deletePhone(Phone phone) throws Exception;

	public List<Phone> listPhones(Integer user_id) throws Exception;
}
