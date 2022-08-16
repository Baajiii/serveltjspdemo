import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sample.domain.Address;
import com.sample.domain.Guide;
import com.sample.domain.Student;
import com.sample.domain.User;
import com.sample.utils.HibernateUtil;

public class StudentTest {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction txn = session.getTransaction();

		try {

			txn.begin();

			Guide guide = new Guide("2000ABC001", "Mike Lawson", 1000);
			Student student1 = new Student("SR001", "Max", guide,20);
			Student student2 = new Student("SR002", "Bob", guide,23);
			
			session.save(guide);
			session.save(student1);
			session.save(student2);
			
			txn.commit();

		} catch (Exception ex) {
			if (txn != null) {
				txn.rollback();
			}
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
	}
	
}