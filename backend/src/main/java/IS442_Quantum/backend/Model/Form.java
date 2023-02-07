package IS442_Quantum.backend.Model;

import java.util.ArrayList;
import jakarta.persistence.*;
import java.sql.Date;
import lombok.*;

@Entity
@AllArgsConstructor
@Data
public class Form {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long form_id;
    private String form_name;
    private Date date_submitted;
    private Date last_edited;

    @OneToMany(mappedBy="form", cascade={CascadeType.ALL})
    private ArrayList<FormInput> formInputs;

    public Form(String form_name, Date date_submitted, Date last_edited, ArrayList<FormInput> formInputs) {
        this.form_name = form_name;
        this.date_submitted = date_submitted;
        this.last_edited = last_edited;
        this.formInputs = formInputs;
    }
}
