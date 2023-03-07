package IS442_Quantum.backend.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sectionId;

    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name="form_id", nullable = false)
    private Form form;

    @OneToMany(mappedBy="section", cascade={CascadeType.ALL})
    private Collection<QuestionSection> questionSections = new ArrayList<>();

    public void addSectionQuestion(QuestionSection qe){
        this.questionSections.add(qe);
        qe.setSection(this);
    }

}
