package relations.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try (SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            Transaction transaction=session.beginTransaction();

            // create a client
            Client client = new Client(0L, "customer name", "customer lastname", null);
            session.save(client);

            //create an order
            Order order = new Order(0l, "order 1", new Date(946684800), 10l);
            session.save(order);

            Order order2 = new Order(0l, "order 2", new Date(946684800), 20l);
            session.save(order2);

            // prepare the list of clients order
            List<Order> listOfOrder = new ArrayList<>();
            listOfOrder.add(order);
            listOfOrder.add(order2);

            //set clients orders
            client.setOrders(listOfOrder);

            session.update(client);

            transaction.commit();

        }
    }

}
