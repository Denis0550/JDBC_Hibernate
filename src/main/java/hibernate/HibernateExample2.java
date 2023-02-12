package hibernate;

import hibernate.entity.Advertisement;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateExample2 {

    public static void main(String[] args) {
        // if you open the session in try-with-resources then you dont need to close it, it will be closed automatically
        // suggested one!
        try (
                SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
                Session session = sessionFactory.openSession()) {

            Advertisement advertisement = new Advertisement();
            advertisement.setPrice(15624);
            advertisement.setRegistrationNumber("123ABC");
            session.save(advertisement);
            //session.close(); //no need to close the session manually, try-with-resource will do it for us

        } catch (Exception e) {

        }


        try (SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Advertisement advertisement = new Advertisement();
            advertisement.setPrice(15624);
            advertisement.setRegistrationNumber("123ABC");
            session.save(advertisement);
            session.close(); //you have to close the session because its opened in try block
        } catch (Exception e) {

        }
    }

}
