package IS442_Quantum.backend.Model;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class FormQId implements Serializable {

    private Long formId;
    private Long questionnaireId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FormQId)) return false;
        FormQId that = (FormQId) o;
        return getFormId().equals(that.getFormId()) && getQuestionnaireId().equals(that.getQuestionnaireId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFormId(), getQuestionnaireId());
    }
}
