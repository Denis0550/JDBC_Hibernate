package hibernate;

import hibernate.entity.Advertisement;
import hibernate.entity.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateExample3 {

    public static void main(String[] args) {

        try (
                SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
                Session session = sessionFactory.openSession()) {
            // i dont want to save the car object, if i can not save the ad
            Transaction transaction = session.beginTransaction();

            // create a car
            Car car = new Car();
            car.setMake("Toyota");
            car.setModel("RAV4");
            car.setColor("White");
            car.setFuel("Diesel");
            car.setYear(0);
            car.setRegistrationNumber("123ABC");
            car.setMilage(15000);
            //save the car
            session.save(car);

            try {
                // try to create an Advertisement for the car
                Advertisement advertisement = new Advertisement();
                advertisement.setPrice(100000 / car.getYear());
                advertisement.setRegistrationNumber("123ABC");
                //save the Advertisement
                session.save(advertisement);
                transaction.commit();
            } catch (Exception e) {
                // iff you can not save the Advertisement then rollback the transaction, that means car also will be rolledback
                transaction.rollback();
                e.printStackTrace();
            }

        } catch (Exception e) {

        }

    }

}
