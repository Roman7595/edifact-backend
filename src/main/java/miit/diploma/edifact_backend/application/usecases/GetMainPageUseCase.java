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
        List<Traveler> travelerList = travelerRepository.getAll();
        List<TravelerResponse> travelerResponseList = new ArrayList<>(travelerList.size());
        for (Traveler traveler : travelerList){
            TravelerResponse travelerResponse = new TravelerResponse(
                    traveler.getId(),
                    traveler.getName()
            );
            travelerResponseList.add(travelerResponse);
        }
        return travelerResponseList;
    }
}
