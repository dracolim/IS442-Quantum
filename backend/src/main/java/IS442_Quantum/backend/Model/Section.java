package IS442_Quantum.backend.Model;

import IS442_Quantum.backend.Enums.UserTypes;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sectionId;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private UserTypes userType;

    @ManyToOne
    @JoinColumn(name="form_id", nullable = false)
    @JsonIgnore
    private Form form;

    @OneToMany(mappedBy="section", cascade={CascadeType.ALL}, orphanRemoval = true)
    private Collection<Question> questions = new ArrayList<>();

    // copy constructor
    public Section(Section section) {
        this.title = section.getTitle();
        this.description = section.getDescription();
        for(Question question : section.getQuestions()){
            addQuestions(new Question(question));
        }
    }

    public void addQuestions(Question question){
        questions.add(question);
        question.setSection(this);
    }



}
