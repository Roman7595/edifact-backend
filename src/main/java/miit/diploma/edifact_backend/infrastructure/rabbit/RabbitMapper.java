//package miit.diploma.edifact_backend.onion.infrastructure.rabbit;
//
//
//import miit.diploma.edifact_backend.onion.domain.models.Message;
//import miit.diploma.edifact_backend.onion.infrastructure.rabbit.dto.MessageQueueDTO;
//import miit.diploma.edifact_backend.onion.infrastructure.rabbit.dto.ParsedMessageQueueDTO;
//
//
//public class RabbitMapper {
//    public MessageQueueDTO modelToDto(Message message){
//        return new MessageQueueDTO(message.getId(), message.getEdifact());
//    }
//    public Message dtoToModel(ParsedMessageQueueDTO message){
//        Message result = new Message(null);
//
//        result.setId(message.id);
//        result.setStructure(message.message);
//        return result;
//    }
//}
