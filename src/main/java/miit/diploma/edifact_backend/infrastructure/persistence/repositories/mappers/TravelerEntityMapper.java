package miit.diploma.edifact_backend.infrastructure.persistence.repositories.mappers;

import miit.diploma.edifact_backend.domain.models.Message;
import miit.diploma.edifact_backend.domain.models.Traveler;
import miit.diploma.edifact_backend.infrastructure.persistence.entites.MessageEntity;
import miit.diploma.edifact_backend.infrastructure.persistence.entites.TravelerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TravelerEntityMapper implements EntityMapper<Traveler, TravelerEntity>{

    private final MessageEntityMapper messageEntityMapper;

    @Autowired
    public TravelerEntityMapper(MessageEntityMapper messageEntityMapper) {
        this.messageEntityMapper = messageEntityMapper;
    }

    public TravelerEntity modelToEntity(Traveler traveler){

        MessageEntity messageEntity = messageEntityMapper.modelToEntity(traveler.getMessage());

        TravelerEntity travelerEntity = new TravelerEntity(
                traveler.getSirname(),
                traveler.getDocumentCountry(),
                traveler.getDocumentType(),
                traveler.getDocumentNumber(),
                traveler.getFileName(),
                traveler.getFileType(),
                traveler.getFileDatetime(),
                messageEntity
        );
        travelerEntity.setId(traveler.getId());

        return travelerEntity
                .setName(traveler.getName())
                .setSecname(traveler.getSecname())
                .setBirthDate(traveler.getBirthDate())
                .setGender(traveler.getGender())
                .setDocumentExpiryDate(traveler.getDocumentExpiryDate())
                .setAirlineIata(traveler.getAirlineIata())
                .setFlightNumber(traveler.getFlightNumber())
                .setArrivalAirportIata(traveler.getArrivalAirportIata())
                .setDepartureAirportIata(traveler.getDepartureAirportIata())
                .setAirlineIata(traveler.getAirlineIata())
                .setEtd(traveler.getEtd())
                .setEta(traveler.getEta())
                .setAtd(traveler.getAtd())
                .setAta(traveler.getAta())
                .setCompanyNameCode(traveler.getCompanyNameCode())
                .setTicketNumber(traveler.getTicketNumber())
                .setFareData(traveler.getFareData())
                .setPaymentData(traveler.getPaymentData())
                .setBaggageData(traveler.getBaggageData())
                .setOperation(traveler.getOperation())
                .setSeverity(traveler.getSeverity());
    }

    public Traveler entityToModel(TravelerEntity travelerEntity){

        Message message = messageEntityMapper.entityToModel(travelerEntity.getMessage());

        Traveler traveler = new Traveler(
                travelerEntity.getSirname(),
                travelerEntity.getDocumentCountry(),
                travelerEntity.getDocumentType(),
                travelerEntity.getDocumentNumber(),
                travelerEntity.getFileName(),
                travelerEntity.getFileType(),
                travelerEntity.getFileDatetime(),
                message
        );

        traveler.setId(travelerEntity.getId());
        traveler.setName(travelerEntity.getName());
        traveler.setSecname(travelerEntity.getSecname());
        traveler.setBirthDate(travelerEntity.getBirthDate());
        traveler.setGender(travelerEntity.getGender());
        traveler.setDocumentExpiryDate(travelerEntity.getDocumentExpiryDate());
        traveler.setAirlineIata(travelerEntity.getAirlineIata());
        traveler.setFlightNumber(travelerEntity.getFlightNumber());
        traveler.setArrivalAirportIata(travelerEntity.getArrivalAirportIata());
        traveler.setDepartureAirportIata(travelerEntity.getDepartureAirportIata());
        traveler.setEtd(travelerEntity.getEtd());
        traveler.setEta(travelerEntity.getEta());
        traveler.setAtd(travelerEntity.getAtd());
        traveler.setAta(travelerEntity.getAta());
        traveler.setCompanyNameCode(travelerEntity.getCompanyNameCode());
        traveler.setTicketNumber(travelerEntity.getTicketNumber());
        traveler.setFareData(travelerEntity.getFareData());
        traveler.setPaymentData(travelerEntity.getPaymentData());
        traveler.setBaggageData(travelerEntity.getBaggageData());
        traveler.setOperation(travelerEntity.getOperation());
        traveler.setSeverity(travelerEntity.getSeverity());

        return traveler;

    }

}
