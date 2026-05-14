package miit.diploma.edifact_backend;

import miit.diploma.edifact_backend.application.usecases.GetAllTravelersUseCase;
import miit.diploma.edifact_backend.application.usecases.ParseMessageUseCase;
import miit.diploma.edifact_backend.application.usecases.SaveParsedMessageUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {
    @Autowired
    private ParseMessageUseCase parseMessageUseCase;
    @Autowired
    private GetAllTravelersUseCase getAllTravelersUseCase;

    @Autowired
    private SaveParsedMessageUseCase saveParsedMessageUseCase;

    @Override
    public void run(String... strings) {
//        parseMessageUseCase.execute(new MessageToParseDTO("message"));
//
//        HashMap<String,Object> structure = new HashMap<>();
//
//        structure.put("id",1);
//        structure.put("name","sadsaname");
//        saveParsedMessageUseCase.execute(new ParsedMessageResponse(1, structure));

//        System.out.println("-------" +getMainPageUseCase.execute());
    }


}