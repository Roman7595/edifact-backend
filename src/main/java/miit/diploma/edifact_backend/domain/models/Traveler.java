package miit.diploma.edifact_backend.domain.models;


import java.time.LocalDateTime;

public class Traveler extends BaseModel{

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
    private Message message;


    public String getSirname() {
        return sirname;
    }

    public String getName() {
        return name;
    }

    public String getSecname() {
        return secname;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public String getGender() {
        return gender;
    }

    public String getDocumentCountry() {
        return documentCountry;
    }

    public String getDocumentType() {
        return documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public LocalDateTime getDocumentExpiryDate() {
        return documentExpiryDate;
    }

    public String getAirlineIata() {
        return airlineIata;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDepartureAirportIata() {
        return departureAirportIata;
    }

    public String getArrivalAirportIata() {
        return arrivalAirportIata;
    }

    public LocalDateTime getEtd() {
        return etd;
    }

    public LocalDateTime getEta() {
        return eta;
    }

    public LocalDateTime getAtd() {
        return atd;
    }

    public LocalDateTime getAta() {
        return ata;
    }

    public String getCompanyNameCode() {
        return companyNameCode;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public String getFareData() {
        return fareData;
    }

    public String getPaymentData() {
        return paymentData;
    }

    public String getBaggageData() {
        return baggageData;
    }

    public String getOperation() {
        return operation;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public LocalDateTime getFileDatetime() {
        return fileDatetime;
    }

    public Integer getSeverity() {
        return severity;
    }

    public Message getMessage() {
        return message;
    }

    public Traveler(String sirname, String documentCountry, String documentType, String documentNumber, String fileName, String fileType, LocalDateTime fileDatetime, Message message) {
        setSirname(sirname);
        setDocumentCountry(documentCountry);
        setDocumentType(documentType);
        setDocumentNumber(documentNumber);
        setFileName(fileName);
        setFileType(fileType);
        setFileDatetime(fileDatetime);
        setMessage(message);

    }


    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setBaggageData(String baggageData) {
        this.baggageData = baggageData;
    }

    public void setPaymentData(String paymentData) {
        this.paymentData = paymentData;
    }

    public void setFareData(String fareData) {
        this.fareData = fareData;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public void setCompanyNameCode(String companyNameCode) {
        this.companyNameCode = companyNameCode;
    }

    public void setAta(LocalDateTime ata) {
        this.ata = ata;
    }

    public void setAtd(LocalDateTime atd) {
        this.atd = atd;
    }

    public void setEta(LocalDateTime eta) {
        this.eta = eta;
    }

    public void setEtd(LocalDateTime etd) {
        this.etd = etd;
    }

    public void setArrivalAirportIata(String arrivalAirportIata) {
        this.arrivalAirportIata = arrivalAirportIata;
    }

    public void setDepartureAirportIata(String departureAirportIata) {
        this.departureAirportIata = departureAirportIata;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setAirlineIata(String airlineIata) {
        this.airlineIata = airlineIata;
    }

    public void setDocumentExpiryDate(LocalDateTime documentExpiryDate) {
        this.documentExpiryDate = documentExpiryDate;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public void setSecname(String secname) {
        this.secname = secname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSeverity(Integer severity) {
        this.severity = severity;
    }


    protected Traveler() {
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public void setSirname(String sirname) {
        this.sirname = sirname;
    }

    public void setDocumentCountry(String documentCountry) {
        this.documentCountry = documentCountry;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public void setFileDatetime(LocalDateTime fileDatetime) {
        this.fileDatetime = fileDatetime;
    }
}
