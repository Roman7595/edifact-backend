package miit.diploma.edifact_backend.application.usecases;

import miit.diploma.edifact_backend.application.dto.TravelerResponse;
import miit.diploma.edifact_backend.domain.models.Traveler;
import miit.diploma.edifact_backend.domain.ports.TravelerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetMainPageUseCase {

    private final TravelerRepository travelerRepository;

    public GetMainPageUseCase(TravelerRepository travelerRepository) {
        this.travelerRepository = travelerRepository;
    }

    public List<TravelerResponse> execute(){
        // TODO: add pagination

        return travelerRepository.findAll(Traveler.class).stream().map(TravelerResponse::from).toList();
    }
}
