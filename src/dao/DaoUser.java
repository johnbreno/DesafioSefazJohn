package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import models.User;

public class DaoUser {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public DaoUser() {
		emf = Persistence.createEntityManagerFactory("sefazhibernate");
		em = emf.createEntityManager();
	}
	
	public void inserUser(User user) throws Exception {
		
		try {
			
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
			em.close();
			emf.close();
			System.out.println("Insert Sucessfully!");
			
		}
		catch (Exception exception) {
			
			throw new Exception("Insert Error!");
			
		}
	}
	
	public void updateUser(User user) throws Exception {
		
		try {
			
			em.getTransaction().begin();
			user = em.merge(user);
			em.getTransaction().commit();
			em.close();
			emf.close();
			System.out.println("Update Sucessfully!");
			
		}
		catch (Exception exception) {
			
			throw new Exception("Update Error!");
		
		}
		
	}
	
	public void deleteUser(User user) throws Exception {
		
		try {
			em.getTransaction().begin();
			user = em.merge(user);
			em.remove(user);
			em.getTransaction().commit();
			em.close();
			emf.close();
			System.out.println("User removed Sucessfully!");
		}
		catch(Exception exception) {
			
			throw new Exception("Error - Can't to remove user!");
			
		}
	}
	
	public List<User> listUser() throws Exception {
		
		try {

			String sql = "SELECT user FROM User user";
			TypedQuery<User> sqlqQuery = em.createQuery(sql, User.class);
			return sqlqQuery.getResultList();
			
		} 
		catch(Exception exception) {
			
			throw new Exception("Error - Can't to list users!");
		}
		
	}
	
	public boolean verifyUserLogin(User user) throws Exception {
		
		boolean result;
		
		List<User> listUsers = null;
		
		try {
			
			String sql = "SELECT user FROM User user WHERE Name = :nome AND Password = :password ";
			TypedQuery<User> sqlQuery = em.createQuery(sql, User.class);
			sqlQuery.setParameter("name", user.getName());
			sqlQuery.setParameter("password", user.getPassword());
			
			listUsers = sqlQuery.getResultList();
			
			result = (listUsers.size() > 0) ? true : false;
			
			return result;
			
		} catch (Exception exception) {
			
			throw new Exception("Error - User Login invalid !");
			
		}
		
		
	}
	
}
