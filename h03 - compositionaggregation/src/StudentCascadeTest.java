import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sample.domain.Address;
import com.sample.domain.Guide;
import com.sample.domain.Student;
import com.sample.domain.User;
import com.sample.utils.HibernateUtil;

public class StudentCascadeTest {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction txn = session.getTransaction();

		try {

			txn.begin();

//			Guide guide = new Guide("2000XYZ003", "Robert Williams", 2000);
			Guide guide = session.get(Guide.class,2L);
			Student student5 = new Student("SR005", "Ed", guide, 23);
			
			session.persist(student5);
			
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