package miit.diploma.edifact_backend.api.web.viewmodel.models;

import miit.diploma.edifact_backend.application.dto.TravelerResponse;
import miit.diploma.edifact_backend.domain.models.Traveler;

import java.time.LocalDateTime;

public record TravelerModel(
        long id,
        String sirname,
        String documentCountry,
        String documentType,
        String documentNumber,
        String fileName,
        String fileType,
        LocalDateTime fileDatetime

) {

    public static TravelerModel from(TravelerResponse traveler){
        return new TravelerModel(
                traveler.id(),
                traveler.sirname(),
                traveler.documentCountry(),
                traveler.documentType(),
                traveler.documentNumber(),
                traveler.fileName(),
                traveler.fileType(),
                traveler.fileDatetime()
        );
    }

}
