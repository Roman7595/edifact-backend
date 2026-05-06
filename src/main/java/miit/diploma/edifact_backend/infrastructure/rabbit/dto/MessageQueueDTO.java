package miit.diploma.edifact_backend.infrastructure.rabbit.dto;

public class MessageQueueDTO {
    public Long id;
    public String message;

    public MessageQueueDTO(Long id, String message) {
        this.id = id;
        this.message = message;

    }
}
