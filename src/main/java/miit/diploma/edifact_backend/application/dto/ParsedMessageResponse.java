package miit.diploma.edifact_backend.application.dto;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.Map;

public record ParsedMessageResponse(
        long id,
        JsonNode structure
) {

}
