package miit.diploma.edifact_backend.application.usecases;

import miit.diploma.edifact_backend.application.dto.ParsedMessageResponse;
import miit.diploma.edifact_backend.domain.models.Message;
import miit.diploma.edifact_backend.domain.models.Traveler;
import miit.diploma.edifact_backend.domain.ports.MessageRepository;
import miit.diploma.edifact_backend.domain.ports.TravelerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaveParsedMessageUseCase {

    private final MessageRepository messageRepository;
    private final TravelerRepository travelerRepository;


    public SaveParsedMessageUseCase(MessageRepository messageRepository, TravelerRepository travelerRepository) {
        this.messageRepository = messageRepository;
        this.travelerRepository = travelerRepository;
    }

    public void execute(ParsedMessageResponse parsedMessage){

        Message message = messageRepository.findById(parsedMessage.id(), Message.class).orElseThrow(RuntimeException::new);
        message.setStructure(parsedMessage.structure());
        messageRepository.update(message);

        List<Traveler> travelerList = message.extractTravelers();

        travelerRepository.saveAll(travelerList);

    }
}
