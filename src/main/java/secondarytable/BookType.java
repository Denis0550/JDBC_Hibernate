package secondarytable;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "book_type")
public class BookType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String type;
}
