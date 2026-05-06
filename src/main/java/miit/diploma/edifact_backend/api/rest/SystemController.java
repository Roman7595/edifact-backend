package miit.diploma.edifact_backend.api.rest;

import miit.diploma.edifact_backend.application.dto.MessageToParseDTO;
import miit.diploma.edifact_backend.application.usecases.ParseMessageUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/system")
public class SystemController {
    private final ParseMessageUseCase parseMessageUsecase;

    public SystemController(ParseMessageUseCase parseMessageUsecase) {
        this.parseMessageUsecase = parseMessageUsecase;
    }

    @PostMapping("/parse_message")
    public void parse_messages(@RequestBody String message){
        parseMessageUsecase.execute(new MessageToParseDTO(message));
    }

}
