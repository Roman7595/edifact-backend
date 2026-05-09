package miit.diploma.edifact_backend.api.web;

import miit.diploma.edifact_backend.application.dto.TravelerResponse;
import miit.diploma.edifact_backend.application.usecases.GetMainPageUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
//@RequestMapping("/api/v1/client")
public class ClientController {

    private final GetMainPageUseCase getMainPageUseCase;

    public ClientController(GetMainPageUseCase getMainPageUseCase) {
        this.getMainPageUseCase = getMainPageUseCase;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<TravelerResponse> travelerResponseList = getMainPageUseCase.execute();
            model.addAttribute("travelerList", travelerResponseList);
        return "index";
    }
}
