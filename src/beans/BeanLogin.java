package beans;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import business.Facade;
import models.User;

@Named(value = "beanLogin")
@RequestScoped
public class BeanLogin implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private User user = new User();
	Facade facade = new Facade();
	private String message; 
	
	public BeanLogin() {

	}
	
	public String verifyUserLogin() throws Exception{
		try {
			if(facade.verifyUserLogin(this.user)) {
				return "listPhone";
			}
			return null;
		} 
		catch (Exception exception) {
			message = "" + exception;
			return null;
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
