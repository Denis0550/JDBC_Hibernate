package secondarytable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {

//        BookType bookType = new BookType();
//        bookType.setType("book type 1");
//      we dont need to insert for secondary table because hibernate will do it for us!

        Book book = new Book();
        book.setTitle("book title");
        book.setType("book type 1");

        try (SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            //session.save(bookType); -> no need to save, it will be saved by hibernate
            session.save(book);
            transaction.commit();
        }


    }

}
