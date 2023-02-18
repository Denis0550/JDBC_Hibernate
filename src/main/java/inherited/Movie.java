package inherited;

import javax.persistence.Entity;

@Entity
public class Movie extends BaseEntity {
    private String title;
    private String description;
    private String type;
}
