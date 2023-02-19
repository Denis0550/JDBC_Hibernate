package hql;

import hibernate.entity.Car;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager=entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        Car car=new Car();
        car.setMake("make3");
        car.setModel("model3");
        car.setYear(2015);
        car.setRegistrationNumber("321ASD");
        car.setFuel("Diesel");
        car.setMilage(2022);
        car.setColor("blue");

        entityManager.persist(car);

        transaction.commit();
        System.out.println(car.getId());


    }

}
