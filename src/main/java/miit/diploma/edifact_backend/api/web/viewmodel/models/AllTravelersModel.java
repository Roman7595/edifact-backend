package miit.diploma.edifact_backend.api.web.viewmodel.models;

import java.util.List;

public record AllTravelersModel(
        List<TravelerModel> travelerModels,
        long count
){}
