package miit.diploma.edifact_backend.application.usecases;

import miit.diploma.edifact_backend.application.dto.TravelerResponse;
import miit.diploma.edifact_backend.domain.ports.TravelerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllTravelersUseCase {

    private final TravelerRepository travelerRepository;

    public GetAllTravelersUseCase(TravelerRepository travelerRepository) {
        this.travelerRepository = travelerRepository;
    }

    public List<TravelerResponse> execute(){
        // TODO: add pagination

        return travelerRepository.findAll().stream().map(TravelerResponse::from).toList();
    }
}
