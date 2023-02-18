package relations.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.Date;

public class Main {

    public static void main(String[] args) {

//        try (SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//             Session session = sessionFactory.openSession()) {
//            Student student = new Student(0L, "john", "doe", new Date(946684800), null);
//            session.save(student);
//        }

        try (SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            StudentBook studentBook = new StudentBook(0L, "BN1234");
            session.save(studentBook);
            transaction.commit();

            Student student = new Student(0L, "joe", "doe", new Date(946684800), studentBook);
            session.save(student);
        }

    }

}
