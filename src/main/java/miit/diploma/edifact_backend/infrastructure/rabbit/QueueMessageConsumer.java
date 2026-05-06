package miit.diploma.edifact_backend.infrastructure.rabbit;


import miit.diploma.edifact_backend.application.dto.ParsedMessageResponse;
import miit.diploma.edifact_backend.application.usecases.SaveParsedMessageUseCase;
import miit.diploma.edifact_backend.infrastructure.rabbit.config.RabbitMQConfig;
import miit.diploma.edifact_backend.infrastructure.rabbit.dto.ParsedMessageQueueDTO;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
public class QueueMessageConsumer{

    private final SaveParsedMessageUseCase saveParsedMessageUsecase;

    public QueueMessageConsumer(ObjectMapper objectMapper, SaveParsedMessageUseCase saveParsedMessageUsecase) {
        this.saveParsedMessageUsecase = saveParsedMessageUsecase;
    }

    @RabbitListener(
            bindings = @QueueBinding(

                    value = @Queue(name = "queue", durable = "true"),
                    exchange = @Exchange(name = RabbitMQConfig.EXCHANGE_NAME, type = "topic")
            )
    )
    public void getMessageFromParse(ParsedMessageQueueDTO parsedMessage) {
//        ParsedMessageQueueDTO structure = objectMapper.readValue(parsedMessage, ParsedMessageQueueDTO.class);
//        Message message = rabbitMapper.dtoToModel(structure);
        saveParsedMessageUsecase.execute(new ParsedMessageResponse(parsedMessage.id, parsedMessage.structure));
    }
}
