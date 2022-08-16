package HibernateTest;
import org.hibernate.Session;

import com.samples.domain.Message;
import com.samples.utils.HibernateUtil;

public class HibernateTest {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		Message message = new Message("Hello world with Hibernate and annotations2");
		Message message1 = new Message("Hello world with Hibernate and annotations2"); 
		Message message2 = new Message("Hello world with Hibernate and annotations2"); 
		Message message3 = new Message("Hello world with Hibernate and annotations2"); 
		Message message4 = new Message("Hello world with Hibernate and annotations2"); 
		Message message5 = new Message("Hello world with Hibernate and annotations2"); 

		
		session.save(message);
		session.save(message1);
		session.save(message2);
		session.save(message3);
		session.save(message4);
		session.save(message5);
		
		session.getTransaction().commit();
		
		session.close();
		
	}
}