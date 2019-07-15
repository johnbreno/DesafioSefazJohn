package main;

import business.Facade;
import models.User;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		
		Facade facade = new Facade();
		User user = new User();
		
		user.setName("Jonatha");
		user.setEmail("breno@gmail.com");
		user.setPassword("12345");
		
		try {
			
			facade.insertUser(user);
			
		} 
		catch (Exception exception) {
			
			System.out.println(exception);
			
		}

	}

}
