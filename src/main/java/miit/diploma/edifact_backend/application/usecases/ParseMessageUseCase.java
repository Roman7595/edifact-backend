package miit.diploma.edifact_backend.application.usecases;

import miit.diploma.edifact_backend.application.dto.MessageToParseDTO;
import miit.diploma.edifact_backend.domain.dto.MessageToParseRequest;
import miit.diploma.edifact_backend.domain.models.Message;
import miit.diploma.edifact_backend.domain.ports.QueueMessageSender;
import miit.diploma.edifact_backend.domain.ports.MessageRepository;
import miit.diploma.edifact_backend.domain.ports.TravelerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class ParseMessageUseCase {

    private static final Logger log = LoggerFactory.getLogger(ParseMessageUseCase.class);
    private final MessageRepository messageRepository;
    private final TravelerRepository travelerRepository;
    private final QueueMessageSender queueMessageSender;


    public ParseMessageUseCase(MessageRepository messageRepository, TravelerRepository travelerRepository, QueueMessageSender queueMessageSender) {
        this.messageRepository = messageRepository;
        this.travelerRepository = travelerRepository;
        this.queueMessageSender = queueMessageSender;
    }

    public void execute(MessageToParseDTO message){

        try{
            Message newMessage = new Message(message.edifact());

            newMessage = messageRepository.save(newMessage);

            queueMessageSender.sendMessageToParse(new MessageToParseRequest(newMessage.getId(),newMessage.getEdifact()));
        } catch (Exception e) {
            log.error("Parse Error", e);
        }

    }

//    List<Message> messageList = new ArrayList<>(messages.size());
//
//        for (String message : messages){
//        Message newMessage = new Message(message);
//        messageList.add(newMessage);
//    }
//
//    messageList = messageRepository.saveAll(messageList);
//
//        for (Message message : messageList){
//        queueMessageSender.sendMessageToParse(message);
//    }
}
