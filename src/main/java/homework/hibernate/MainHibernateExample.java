package homework.hibernate;

import homework.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainHibernateExample {

    public static void main(String[] args) {
//        first option
//        Employee employee = new Employee();
//        employee.setName("name 1");
//        employee.setSurname("surname 1");
//        employee.setSalary(1500);
//        employee.setPersonalId("12121213131");

        //second option
        Employee employee = new Employee(0L, "12121213131", "name", "surname", 1500);
        insertEmployee(employee);

        employee.setSalary(1750);
        updateEmployee(employee);
        deleteEmployee(employee);
    }

    static void insertEmployee(Employee employee) {
        try (SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.save(employee);
        }
    }

    static void updateEmployee(Employee employee) {
        try (SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(employee);
            transaction.commit();
        }
    }

    static void deleteEmployee(Employee employee) {
        try (SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        }
    }

}
