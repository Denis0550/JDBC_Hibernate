package homework.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    //you have to use Column annotation because field name in db and variable name is different
    @Column(name = "personal_id")
    private String personalId;

    //its up to you, both is okay, i preferred not to use
    private String name;

    //its up to you, both is okay, i preferred not to use
    private String surname;

    //its up to you, both is okay, i preferred using column annotation
    @Column(name = "salary")
    private int salary;

}
