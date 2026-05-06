package miit.diploma.edifact_backend.infrastructure.rabbit.dto;

import java.util.Map;

public class ParsedMessageQueueDTO {
    public Long id;
    public Map<String, Object> structure;

    public ParsedMessageQueueDTO(Long id, Map<String, Object> structure) {
        this.id = id;
        this.structure = structure;

    }
}
