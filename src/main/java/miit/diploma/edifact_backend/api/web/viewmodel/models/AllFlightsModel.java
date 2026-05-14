package miit.diploma.edifact_backend.api.web.viewmodel.models;

import java.util.List;

public record AllFlightsModel(
        List<FlightModel> flightModels,
        long count
){}
