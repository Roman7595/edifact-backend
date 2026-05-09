package miit.diploma.edifact_backend.infrastructure.persistence.entites;

import com.fasterxml.jackson.databind.JsonNode;
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
    private JsonNode structure;

    protected MessageEntity() {
    }

    public MessageEntity(String edifact) {
        setEdifact(edifact);
    }


    @Column(name="edifact", columnDefinition = "TEXT", nullable=false)
    public String getEdifact() {
        return edifact;
    }

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name="structure")
    public JsonNode getStructure() {
        return structure;
    }


    public void setStructure(JsonNode structure) {
        this.structure = structure;
    }

    public void setEdifact(String edifact) {
        this.edifact = edifact;
    }
}
