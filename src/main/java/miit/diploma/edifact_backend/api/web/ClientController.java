package miit.diploma.edifact_backend.api.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public interface ClientController {

    @GetMapping("/")
    public String main(Model model);

    @GetMapping("/flights")
    public String flights(Model model);
}
