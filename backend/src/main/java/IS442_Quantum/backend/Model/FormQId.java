package IS442_Quantum.backend.Model;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class FormQuestionnairesId implements Serializable {

    private Long formId;
    private Long inputId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FormQuestionnairesId)) return false;
        FormQuestionnairesId that = (FormQuestionnairesId) o;
        return getFormId().equals(that.getFormId()) && getInputId().equals(that.getInputId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFormId(), getInputId());
    }
}
