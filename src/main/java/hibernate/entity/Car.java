package hibernate.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "CAR")
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String make;

    private String model;

    private int year;
    @Column(name = "RegistrationNumber")
    private String registrationNumber;
    @Column(name = "Fuel")
    private String fuel;
    @Column(name = "Milage")
    private int milage;
    @Column(name = "Color")
    private String color;
}
