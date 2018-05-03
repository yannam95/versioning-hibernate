


import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;

public class Datainsertion {
	

	public static void main(String[] args) {
		Transaction tx =  null;
	
		      
		   SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		      Session session = sessionFactory.openSession();
		

		     
		     
		      
		      try {
		     
		    	  
		    	  tx = session.beginTransaction();
		           
		    	  
		    	  Student std1 = new Student(); 
		         
		    	  std1.setId(1);
		    	  std1.setName("Deeraj");
		    	  std1.setMajor("computer science");
		    	  std1.setGpa(3.7);
		    	  Student std2 = new Student(); 
			         
		    	  std2.setId(2);
		    	  std2.setName("Sai");
		    	  std2.setMajor("Electronics");
		    	  std2.setGpa(3.8);
		    	

		    			  
		    			  session.persist(std1);
		    			  session.persist(std2);
		    			  
		    			  
		         tx.commit();
		      } catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      } finally {
		         session.close(); 
		      }
		      
	}
}
