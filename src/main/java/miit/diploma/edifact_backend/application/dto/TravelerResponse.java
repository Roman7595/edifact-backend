package miit.diploma.edifact_backend.application.dto;

import miit.diploma.edifact_backend.domain.models.Traveler;

import java.time.LocalDateTime;

public record TravelerResponse(
        long id,
        String sirname,
        String documentCountry,
        String documentType,
        String documentNumber,
        String fileName,
        String fileType,
        LocalDateTime fileDatetime

) {

    public static TravelerResponse from(Traveler traveler){
        return new TravelerResponse(
                traveler.getId(),
                traveler.getSirname(),
                traveler.getDocumentCountry(),
                traveler.getDocumentType(),
                traveler.getDocumentNumber(),
                traveler.getFileName(),
                traveler.getFileType(),
                traveler.getFileDatetime()
        );
    }

}
