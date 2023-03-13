package IS442_Quantum.backend.Model;

import jakarta.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;


import lombok.*;

@Entity
@Data
@NoArgsConstructor
public class Form {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long formId;
    private String formName;
    private Date dateSubmitted;
    private Date lastEdited;

    @OneToMany(mappedBy="form", cascade={CascadeType.ALL})
    private Collection<Section> sections = new ArrayList<>();

    // copy constructor
    public Form(Form form) {
        this.formName = form.getFormName();
        this.dateSubmitted = form.getDateSubmitted();
        this.lastEdited = form.getLastEdited();
        for(Section section : form.getSections()){
            addSections(new Section(section));
        }
    }

    public void addSections(Section section){
        sections.add(section);
        section.setForm(this);
    }

}
