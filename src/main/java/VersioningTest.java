

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class VersioningTest {
	
	 

	 public static void main(String[] args) {
			
			
			
			
			Thread t1 = new Thread(new Runnable() {
				
				 Session session1=HibernateUtil.getSessionFactory().openSession();
				Transaction tx = null;
				

				public void run() {
					Student samp1 = session1.get(Student.class, 1);
					if (samp1 != null) {
						tx = session1.beginTransaction();

						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						samp1.setGpa(3.8);
						session1.update(samp1);
						tx.commit();
					}
				}
			});

			Thread t2 = new Thread(new Runnable() {
				
				Session session2=HibernateUtil.getSessionFactory().openSession();
				Transaction tx = null;

				public void run() {
					Student samp2 = session2.get(Student.class, 1);
					if (samp2 != null) {
						tx = session2.beginTransaction();
						samp2.setGpa(3.9);
						session2.update(samp2);
						tx.commit();
					}
				}
			});

			t1.start();
			t2.start();
		}

}