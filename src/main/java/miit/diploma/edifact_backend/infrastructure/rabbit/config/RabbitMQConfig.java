package miit.diploma.edifact_backend.infrastructure.rabbit.config;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    public static final String PARSED_EXCHANGE_NAME = "parsed-message";

    public static final String EXCHANGE_NAME = "message-to-parse";
    public static final String ROUTING_KEY_MESSAGE_CREATED = "message.created";
    public static final String ROUTING_KEY_MESSAGE_PARSED = "message.parsed";

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }


    @Bean
    public TopicExchange messageExchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }
}

