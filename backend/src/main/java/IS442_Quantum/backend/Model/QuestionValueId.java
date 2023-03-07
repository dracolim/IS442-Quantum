package IS442_Quantum.backend.Model;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class QuestionValueId implements Serializable {

    private Long formId;
    private Long questionId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuestionValueId)) return false;
        QuestionValueId that = (QuestionValueId) o;
        return getFormId().equals(that.getFormId()) && getQuestionId().equals(that.getQuestionId());
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(getFormId(), getQuestionId());
    }

}
