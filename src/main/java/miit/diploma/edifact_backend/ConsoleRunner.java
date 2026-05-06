package miit.diploma.edifact_backend;

import miit.diploma.edifact_backend.application.dto.MessageToParseDTO;
import miit.diploma.edifact_backend.application.dto.ParsedMessageResponse;
import miit.diploma.edifact_backend.application.usecases.GetMainPageUseCase;
import miit.diploma.edifact_backend.application.usecases.ParseMessageUseCase;
import miit.diploma.edifact_backend.application.usecases.SaveParsedMessageUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Component
public class ConsoleRunner implements CommandLineRunner {
    @Autowired
    private ParseMessageUseCase parseMessageUseCase;
    @Autowired
    private GetMainPageUseCase getMainPageUseCase;

    @Autowired
    private SaveParsedMessageUseCase saveParsedMessageUseCase;

    @Override
    public void run(String... strings) {
        long id = parseMessageUseCase.execute(new MessageToParseDTO("message"));

        saveParsedMessageUseCase.execute(new ParsedMessageResponse(id, new HashMap<>()));

        System.out.println(getMainPageUseCase.execute());
    }


}