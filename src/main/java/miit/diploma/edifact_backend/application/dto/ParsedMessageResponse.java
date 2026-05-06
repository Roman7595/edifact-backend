package miit.diploma.edifact_backend.application.dto;

import java.util.Map;

public record ParsedMessageResponse(
        long id,
        Map<String,Object> structure
) {

}
