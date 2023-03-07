package IS442_Quantum.backend.Model;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class QuestionSectionId implements Serializable {

    private Long questionId;
    private Long sectionId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuestionSectionId)) return false;
        QuestionSectionId that = (QuestionSectionId) o;
        return getQuestionId().equals(that.getQuestionId()) && getSectionId().equals(that.getSectionId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQuestionId(), getSectionId());
    }
}
