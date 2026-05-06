package miit.diploma.edifact_backend.infrastructure.persistence.entites;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="travelers")
public class TravelerEntity extends BaseEntity {

    private String sirname;
    private String name;
    private String secname;
    private LocalDateTime birthDate;
    private String gender;
    private String  documentCountry;
    private String documentType;
    private String documentNumber;
    private LocalDateTime documentExpiryDate;
    private String airlineIata;
    private String flightNumber;
    private String departureAirportIata;
    private String arrivalAirportIata;
    private LocalDateTime etd;
    private LocalDateTime eta;
    private LocalDateTime atd;
    private LocalDateTime ata;
    private String companyNameCode;
    private String ticketNumber;
    private String fareData;
    private String paymentData;
    private String baggageData;
    private String operation;
    private String fileName;
    private String fileType;
    private LocalDateTime fileDatetime;
    private Integer severity;
    private MessageEntity message;

    @Column(name="sirname", nullable=false)
    public String getSirname() {
        return sirname;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    @Column(name="secname")
    public String getSecname() {
        return secname;
    }

    @Column(name="birth_date")
    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    @Column(name="gender")
    public String getGender() {
        return gender;
    }

    @Column(name="document_country", nullable=false)
    public String getDocumentCountry() {
        return documentCountry;
    }

    @Column(name="document_type", nullable=false)
    public String getDocumentType() {
        return documentType;
    }

    @Column(name="document_number", nullable=false)
    public String getDocumentNumber() {
        return documentNumber;
    }

    @Column(name="document_expiry_date")
    public LocalDateTime getDocumentExpiryDate() {
        return documentExpiryDate;
    }

    @Column(name="airline_iata")
    public String getAirlineIata() {
        return airlineIata;
    }

    @Column(name="flight_number")
    public String getFlightNumber() {
        return flightNumber;
    }

    @Column(name="departure_airport_iata")
    public String getDepartureAirportIata() {
        return departureAirportIata;
    }

    @Column(name="arrival_airport_iata")
    public String getArrivalAirportIata() {
        return arrivalAirportIata;
    }

    @Column(name="etd")
    public LocalDateTime getEtd() {
        return etd;
    }

    @Column(name="eta")
    public LocalDateTime getEta() {
        return eta;
    }

    @Column(name="atd")
    public LocalDateTime getAtd() {
        return atd;
    }

    @Column(name="ata")
    public LocalDateTime getAta() {
        return ata;
    }

    @Column(name="company_name_code")
    public String getCompanyNameCode() {
        return companyNameCode;
    }

    @Column(name="ticket_number")
    public String getTicketNumber() {
        return ticketNumber;
    }

    @Column(name="fare_data")
    public String getFareData() {
        return fareData;
    }

    @Column(name="payment_data")
    public String getPaymentData() {
        return paymentData;
    }

    @Column(name="baggage_data")
    public String getBaggageData() {
        return baggageData;
    }

    @Column(name="operation")
    public String getOperation() {
        return operation;
    }

    @Column(name="file_name", nullable=false)
    public String getFileName() {
        return fileName;
    }

    @Column(name="file_type", nullable=false)
    public String getFileType() {
        return fileType;
    }

    @Column(name="file_datetime", nullable=false)
    public LocalDateTime getFileDatetime() {
        return fileDatetime;
    }

    @Column(name="severity")
    public Integer getSeverity() {
        return severity;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="message_id")
    public MessageEntity getMessage() {
        return message;
    }


    public TravelerEntity(String sirname, String documentCountry, String documentType, String documentNumber, String fileName, String fileType, LocalDateTime fileDatetime, MessageEntity message) {

        setSirname(sirname);
        setDocumentCountry(documentCountry);
        setDocumentType(documentType);
        setDocumentNumber(documentNumber);
        setFileName(fileName);
        setFileType(fileType);
        setFileDatetime(fileDatetime);
        setMessage(message);

    }

    public TravelerEntity setOperation(String operation) {
        if (operation != null){
            this.operation = operation;
        }
        return this;
    }

    public TravelerEntity setBaggageData(String baggageData) {

        if(baggageData != null){
            this.baggageData = baggageData;
        }
        return this;
    }

    public TravelerEntity setPaymentData(String paymentData) {

        if(paymentData != null){
            this.paymentData = paymentData;
        }
        return this;
    }

    public TravelerEntity setFareData(String fareData) {

        if (fareData != null){
            this.fareData = fareData;
        }
        return this;
    }

    public TravelerEntity setTicketNumber(String ticketNumber) {

        if(ticketNumber != null){
            this.ticketNumber = ticketNumber;
        }
        return this;
    }

    public TravelerEntity setCompanyNameCode(String companyNameCode) {

        if(companyNameCode != null){
            this.companyNameCode = companyNameCode;
        }
        return this;
    }

    public TravelerEntity setAta(LocalDateTime ata) {

        if (ata != null){
            this.ata = ata;
        }
        return this;
    }

    public TravelerEntity setAtd(LocalDateTime atd) {

        if(atd != null){
            this.atd = atd;
        }
        return this;
    }

    public TravelerEntity setEta(LocalDateTime eta) {

        if(eta != null){
            this.eta = eta;
        }
        return this;
    }

    public TravelerEntity setEtd(LocalDateTime etd) {

        if(etd != null){
            this.etd = etd;
        }
        return this;
    }

    public TravelerEntity setArrivalAirportIata(String arrivalAirportIata) {

        if(arrivalAirportIata != null){
            this.arrivalAirportIata = arrivalAirportIata;
        }
        return this;
    }

    public TravelerEntity setDepartureAirportIata(String departureAirportIata) {

        if(departureAirportIata != null){
            this.departureAirportIata = departureAirportIata;
        }
        return this;
    }

    public TravelerEntity setFlightNumber(String flightNumber) {

        if(flightNumber != null){
            this.flightNumber = flightNumber;
        }
        return this;
    }

    public TravelerEntity setAirlineIata(String airlineIata) {

        if(airlineIata != null){
            this.airlineIata = airlineIata;
        }
        return this;
    }

    public TravelerEntity setDocumentExpiryDate(LocalDateTime documentExpiryDate) {

        if(documentExpiryDate != null){
            this.documentExpiryDate = documentExpiryDate;
        }
        return this;
    }

    public TravelerEntity setGender(String gender) {

        if(gender != null){
            this.gender = gender;
        }
        return this;
    }

    public TravelerEntity setBirthDate(LocalDateTime birthDate) {

        if(birthDate != null){
            this.birthDate = birthDate;
        }
        return this;
    }

    public TravelerEntity setSecname(String secname) {

        if(secname != null){
            this.secname = secname;
        }
        return this;
    }

    public TravelerEntity setName(String name) {

        if(name != null){
            this.name = name;
        }
        return this;
    }

    public TravelerEntity setSeverity(Integer severity) {

        if(severity != null){
            this.severity = severity;
        }
        return this;
    }


    protected TravelerEntity() {
    }

    public void setMessage(MessageEntity message) {

        if(message != null){
            this.message = message;
        }
    }

    public void setSirname(String sirname) {

        if(sirname != null){
            this.sirname = sirname;
        }
    }

    public void setDocumentCountry(String documentCountry) {

        if(documentCountry != null){
            this.documentCountry = documentCountry;
        }
    }

    public void setDocumentType(String documentType) {

        if(documentType != null){
            this.documentType = documentType;
        }
    }

    public void setDocumentNumber(String documentNumber) {

        if(documentNumber != null){
            this.documentNumber = documentNumber;
        }
    }

    public void setFileName(String fileName) {

        if(fileName != null){
            this.fileName = fileName;
        }
    }

    public void setFileType(String fileType) {

        if(fileType != null){
            this.fileType = fileType;
        }
    }

    public void setFileDatetime(LocalDateTime fileDatetime) {

        if(fileDatetime != null){
            this.fileDatetime = fileDatetime;
        }
    }
}
