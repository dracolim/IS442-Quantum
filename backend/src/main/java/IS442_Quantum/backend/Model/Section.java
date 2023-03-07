package IS442_Quantum.backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Form form;

    @OneToMany(mappedBy="section", cascade={CascadeType.ALL})
    private Collection<Question> questions = new ArrayList<>();



}
