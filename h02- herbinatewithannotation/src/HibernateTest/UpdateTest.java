package HibernateTest;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.samples.domain.Message;
import com.samples.utils.HibernateUtil;

public class UpdateTest {

	public static void main(String[] args) {

		Session session1 = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session1.getTransaction();
		txn.begin();
		Message message = session1.get(Message.class, 6);
		System.out.println(message);
		txn.commit();
		session1.close();

		message.setText("Object with Id 6 changed text");		// message object is detached

		Session session2 = HibernateUtil.getSessionFactory().openSession();
		session2.beginTransaction();
		session2.update(message);
		session2.getTransaction().commit();
		session2.close();

	}
}