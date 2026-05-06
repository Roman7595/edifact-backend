package miit.diploma.edifact_backend.domain.ports;

import miit.diploma.edifact_backend.domain.dto.MessageToParseRequest;

public interface QueueMessageSender {
    void sendMessageToParse(MessageToParseRequest message);
}
