package secondarytable;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "book")
@SecondaryTable(name = "book_type") // hey hibernate, please manage this secondary table for me!
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(table = "book_type")
    private String type;
}