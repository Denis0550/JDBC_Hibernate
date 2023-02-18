package embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {

        Mammal mammal = new Mammal();
        Animal animal = new Animal();
        animal.setName("animal name");
        animal.setType("animal type");
        mammal.setAnimal(animal);

        try (SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            //session.save(animal); -> dont do this like me :)
            session.save(mammal);
            transaction.commit();
        }

    }

}
