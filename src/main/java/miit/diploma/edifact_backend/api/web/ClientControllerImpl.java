package miit.diploma.edifact_backend.api.web;

import miit.diploma.edifact_backend.api.web.viewmodel.models.AllFlightsModel;
import miit.diploma.edifact_backend.api.web.viewmodel.models.AllTravelersModel;
import miit.diploma.edifact_backend.api.web.viewmodel.models.FlightModel;
import miit.diploma.edifact_backend.api.web.viewmodel.models.TravelerModel;
import miit.diploma.edifact_backend.application.dto.TravelerResponse;
import miit.diploma.edifact_backend.application.usecases.GetAllFlightsUseCase;
import miit.diploma.edifact_backend.application.usecases.GetAllTravelersUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Map;

@Controller
public class ClientControllerImpl implements ClientController {

    private final GetAllTravelersUseCase getAllTravelersUseCase;
    private final GetAllFlightsUseCase getAllFlightsUseCase;

    public ClientControllerImpl(GetAllTravelersUseCase getAllTravelersUseCase, GetAllFlightsUseCase getAllFlightsUseCase) {
        this.getAllTravelersUseCase = getAllTravelersUseCase;
        this.getAllFlightsUseCase = getAllFlightsUseCase;
    }

    public String main(Model model) {
        List<TravelerResponse> travelerResponseList = getAllTravelersUseCase.execute();
        AllTravelersModel travelerModels = new AllTravelersModel(
                travelerResponseList.stream().map(TravelerModel::from).toList(),
                travelerResponseList.size()
        );
        model.addAttribute("travelerList", travelerModels);
        return "allTravelers";
    }

    @Override
    public String flights(Model model) {
        List<FlightModel> list = getAllFlightsUseCase.execute().entrySet().stream().map(FlightModel::from).toList();
        AllFlightsModel allFlightsModel = new AllFlightsModel(list,list.size());
        model.addAttribute("flights", allFlightsModel);

        return "allFlights";
    }
}
