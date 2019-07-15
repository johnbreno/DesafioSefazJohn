package business;

import java.util.List;

import dao.DaoPhone;
import dao.IDaoPhone;
import models.Phone;

public class BusPhone implements IDaoPhone {
	
	public static DaoPhone daoPhone = new DaoPhone();
	
	public boolean verifyBasicData(Phone phone) throws Exception {
		
		if (phone == null) {
			throw new Exception("Error - Enter at least one Contact Phone !");
		}
		
		if (phone.getDdd() == null) {
			throw new Exception("Error - Enter the DDD !");
		}
		
		if (phone.getDdd() != 3) {
			throw new Exception("Error - The DDD must have 3 characters !");
		}
		
		if (phone.getNumber() == null) {
			throw new Exception("Error - Enter the Number !");
		}
		
		if (phone.getNumber() != 9) {
			throw new Exception("Error - The Number must have 9 characters !");
		}
		
		if ((phone.getType() == null) 
				|| (phone.getType().isEmpty() == true) 
				|| (phone.getType().trim().isEmpty())) {
			throw new Exception("Error - Enter the Type of Number !");
		}
		
		return true;
	}

	@Override
	public void insertPhone(Phone phone) throws Exception {
		try {
			if(verifyBasicData(phone)) {
				daoPhone.insertPhone(phone);
			}
			
		} catch (Exception exception) {
			throw exception;
		}
	}

	@Override
	public void updatePhone(Phone phone) throws Exception {
		try {
			if(verifyBasicData(phone)) {
				daoPhone.updatePhone(phone);
			}
		} catch (Exception exception) {
			throw exception;
		}
	}

	@Override
	public void deletePhone(Phone phone) throws Exception {
		try {
			if(verifyBasicData(phone)) {
				daoPhone.deletePhone(phone);
			}
		} catch (Exception exception) {
			throw exception;
		}
	}

	@Override
	public List<Phone> listPhones(Integer user_id) throws Exception {
		try {
			return daoPhone.listPhone(user_id);
		} catch (Exception exception) {
			throw exception;
		}
	}
	
	

}
