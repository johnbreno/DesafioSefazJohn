package beans;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import business.Facade;
import models.User;

@Named(value = "beanUser")
@RequestScoped
public class BeanUser implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public BeanUser() {
		
	}
	
	private User user = new User();
	private List<User> listUsers;
	Facade facade = new Facade();
	
	
	public void addMessage(String msg) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public String insertUser() throws Exception {
		try {
			facade.insertUser(this.user);
			addMessage("User Added Sucessfully !");
			return "home";
		} 
		catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}
	
	public void listUser() throws Exception {
		try {
			listUsers = facade.listUser();
			addMessage("Query performed successfully !");
		} 
		catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getListUsers() {
		return listUsers;
	}

	public void setListUsers(List<User> listUsers) {
		this.listUsers = listUsers;
	}
	
}
