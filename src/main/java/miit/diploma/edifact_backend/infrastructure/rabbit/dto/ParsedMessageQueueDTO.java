package miit.diploma.edifact_backend.infrastructure.rabbit.dto;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.Map;

public class ParsedMessageQueueDTO {
    public Long id;
    public JsonNode structure;

    public ParsedMessageQueueDTO(Long id, JsonNode structure) {
        this.id = id;
        this.structure = structure;
    }

    public ParsedMessageQueueDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public JsonNode getStructure() {
        return structure;
    }

    public void setStructure(JsonNode structure) {
        this.structure = structure;
    }
}
