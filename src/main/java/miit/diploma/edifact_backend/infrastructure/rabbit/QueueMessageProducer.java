package miit.diploma.edifact_backend.infrastructure.rabbit;

import miit.diploma.edifact_backend.domain.dto.MessageToParseRequest;
import miit.diploma.edifact_backend.domain.ports.QueueMessageSender;
import miit.diploma.edifact_backend.infrastructure.rabbit.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueueMessageProducer implements QueueMessageSender {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public QueueMessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void sendMessageToParse(MessageToParseRequest message) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY_MESSAGE_CREATED, message);
    }
}
