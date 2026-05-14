package miit.diploma.edifact_backend.application.usecases;

import miit.diploma.edifact_backend.application.dto.TravelerResponse;
import miit.diploma.edifact_backend.domain.models.Traveler;
import miit.diploma.edifact_backend.domain.ports.TravelerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GetAllFlightsUseCase {

    private final TravelerRepository travelerRepository;

    public GetAllFlightsUseCase(TravelerRepository travelerRepository) {
        this.travelerRepository = travelerRepository;
    }

    public Map<String, Long> execute(){
        // TODO: add pagination

        return travelerRepository.findAll().stream().filter(Traveler::hasFlight).collect(Collectors.groupingBy(Traveler::getFlightNumber,Collectors.counting()));
    }
}
