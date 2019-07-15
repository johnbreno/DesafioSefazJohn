package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import models.Phone;

public class DaoPhone {

	EntityManagerFactory emf;
	EntityManager em;
	
	public DaoPhone() {
		
		emf = Persistence.createEntityManagerFactory("sefazhibernate");
		em = emf.createEntityManager();
	}
	
	public void insertPhone(Phone phone) throws Exception {
		
		try {
			
			em.getTransaction().begin();
			em.persist(phone);
			em.getTransaction().commit();
			em.close();
			emf.close();
			System.out.println("Insert Phone Sucessfully !");
			
		} catch (Exception exception) {
			
			throw new Exception("Error - Can't to insert Phone !");
		}
	}
	
	public void updatePhone(Phone phone) throws Exception {
		
		try {
			
			em.getTransaction().begin();
			phone = em.merge(phone);
			em.getTransaction().commit();
			em.close();
			emf.close();
			System.out.println("Update Phone Sucessfully !");
			
		} catch (Exception exception) {
			
			throw new Exception("Error - Can't to update Phone !");
		}
		
	}
	
	public void deletePhone(Phone phone) throws Exception {
		
		try {
			
			em.getTransaction().begin();
			phone = em.merge(phone);
			em.remove(phone);
			em.getTransaction().commit();
			em.close();
			emf.close();
			System.out.println("Phone Removed sucessfully");
			
		} catch (Exception exception) {
			
			throw new Exception("Error - Can't to remove Phone !");
			
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Phone> listPhone(Integer user_id) throws Exception {
		
		try {
			
			String sql = "SELECT ddd, number, type FROM Phone WHERE user_id = " + user_id;
			
			return em.createQuery(sql).getResultList();
			
		} catch (Exception exception) {
			
			throw new Exception("Error - Con't to list Phones !");
			
		}
	}
	
	
}
