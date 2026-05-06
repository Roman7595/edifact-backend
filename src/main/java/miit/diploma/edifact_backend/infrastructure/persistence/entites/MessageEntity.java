package miit.diploma.edifact_backend.infrastructure.persistence.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Map;

@Entity
@Table(name="messages")
public class MessageEntity extends BaseEntity {

    private String edifact;
    private Map<String, Object> structure;

    protected MessageEntity() {
    }

    public MessageEntity(String edifact) {
        setEdifact(edifact);
    }


    @Column(name="edifact", nullable=false)
    public String getEdifact() {
        return edifact;
    }

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name="structure")
    public Map<String, Object> getStructure() {
        return structure;
    }


    public void setStructure(Map<String, Object> structure) {
        this.structure = structure;
    }

    public void setEdifact(String edifact) {
        this.edifact = edifact;
    }
}
