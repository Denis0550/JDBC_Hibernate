package embeddable;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "mammal")
public class Mammal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Embedded
    private Animal animal;

}
