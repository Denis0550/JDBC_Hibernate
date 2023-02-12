package hibernate.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Advertisement")
public class Advertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private int price;

    @Column(name = "carRegistrationNumber")
    private String registrationNumber;

}
