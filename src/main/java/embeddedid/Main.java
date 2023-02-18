package embeddedid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        TeacherId teacherId=new TeacherId();
        teacherId.setDocumentId(1);
        teacherId.setLicence("123");

        Person person=new Person();
        person.setFirstName("john");
        person.setLastName("doe");

        Teacher teacher=new Teacher();
        teacher.setPerson(person);
        teacher.setTeacherId(teacherId);

        try (SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(teacher);
            transaction.commit();
        }

    }
}
