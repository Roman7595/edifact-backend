package miit.diploma.edifact_backend.infrastructure.persistence.repositories.mappers;

import miit.diploma.edifact_backend.infrastructure.persistence.entites.MessageEntity;
import miit.diploma.edifact_backend.domain.models.Message;
import org.springframework.stereotype.Component;

@Component
public class MessageEntityMapper implements EntityMapper<Message, MessageEntity>{
    public MessageEntity modelToEntity(Message message){
        MessageEntity messageEntity = new MessageEntity(message.getEdifact());
        messageEntity.setId(message.getId());
        messageEntity.setStructure(message.getStructure());

        return messageEntity;
    }

    public Message entityToModel(MessageEntity message){
        Message result = new Message(message.getEdifact());
        result.setId(message.getId());
        result.setStructure(message.getStructure());
        return result;
    }

}
