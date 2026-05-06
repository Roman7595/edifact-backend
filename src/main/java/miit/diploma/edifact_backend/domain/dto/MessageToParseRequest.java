package miit.diploma.edifact_backend.domain.dto;

public record MessageToParseRequest(
        long id,
        String edifact
) {

}
