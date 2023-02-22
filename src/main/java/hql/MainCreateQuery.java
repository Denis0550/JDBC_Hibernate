package hql;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import hibernate.entity.Car;

import javax.persistence.EntityManager;
import java.util.List;


public class MainCreateQuery {

    public static void main(MysqlxDatatypes.Scalar.String[] args) {

        EntityManager entityManager = SDAEntityManager.getEntityManager();


        //List<Car> carList = entityManager.createQuery("FROM Car c", Car.class).getResultList();
        //for (Car car : carList) {
        //   System.out.println(car.toString());
        //}

//        List<String> carRegistrationNumberList = entityManager.createQuery("Select c.registrationNumber FROM Car c", String.class).getResultList();
//
//        for (String carRegNumber : carRegistrationNumberList) {
//            System.out.println(carRegNumber);
//        }


        // limit 3
//        List<String> carRegistrationNumberListWithMaxResult = entityManager.createQuery("Select c.registrationNumber FROM Car c", String.class).setMaxResults(2).getResultList();
//
//        for (String carRegNumber : carRegistrationNumberListWithMaxResult) {
//            System.out.println(carRegNumber);
//        }

//        List<Car> carListModelGreaterThen = entityManager.createQuery("FROM Car c where c.year>2005", Car.class).getResultList();
//
//        for (Car car : carListModelGreaterThen) {
//            System.out.println(car.toString());
//        }

//        List<Car> carListModelGreaterThen = entityManager.createQuery("FROM Car c order by c.year desc", Car.class).getResultList();
//
//        for (Car car : carListModelGreaterThen) {
//            System.out.println(car.toString());
//        }

//        List<Object> carListModelGreaterThen = entityManager.createQuery("select avg(c.milage) FROM Car c group by c.fuel", Object.class).getResultList();
//
//        for (Object returnedValue : carListModelGreaterThen) {
//            System.out.println(returnedValue.toString());
//        }


        List<Car> listOfCar = entityManager.createQuery("select c FROM Car c where c.registrationNumber= :registrationNumberParameter", Car.class)
                .setParameter("registrationNumberParameter", "123ABC")
                .getResultList();

        for (Car car : listOfCar) {
            System.out.println(car.toString());
        }

    }

}
