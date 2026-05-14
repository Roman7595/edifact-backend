package miit.diploma.edifact_backend.api.web.viewmodel.models;

import miit.diploma.edifact_backend.application.dto.TravelerResponse;

import java.time.LocalDateTime;
import java.util.Map;

public record FlightModel(
        String flightNumber,
        Long count
) {

    public static FlightModel from(Map.Entry<String,Long> map){
        return new FlightModel(
                map.getKey(),
                map.getValue()
        );
    }

}
