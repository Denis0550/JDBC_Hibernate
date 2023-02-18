package embeddedid;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table //-> optional
public class Teacher {

    @EmbeddedId
    private TeacherId teacherId;

    @Embedded
    private Person person;

}
