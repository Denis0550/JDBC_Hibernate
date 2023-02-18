package embeddable;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class Animal {

    private String name;

    private String type;
}
