package Models;

import java.util.Date;
import java.util.GregorianCalendar;

public class EventModel {

    private int idEvent;
    private String title;
    private String description;
    private String additionnalInformation;
    private Boolean isImportant;
    private Date startDate;
    private Date endDate;
    private double price;
    private int participantNbMax;
    private Boolean isPrivate;

    private int fk_creator, fk_eventType, fk_address;


    public EventModel(String title, String description, String additionnalInformation, Boolean isImportant, Date startDate, Date endDate, double price, int participantNbMax, Boolean isPrivate, int fk_creator, int fk_eventType, int fk_address) {
        setTitle(title);
        setDescription(description);
        setAdditionnalInformation(additionnalInformation);
        setImportant(isImportant);
        setStartDate(startDate);
        setEndDate(endDate);
        setPrice(price);
        setParticipantNbMax(participantNbMax);
        setPrivate(isPrivate);
        setFk_creator(fk_creator);
        setFk_eventType(fk_eventType);
        setFk_address(fk_address);
    }

    public EventModel(String title, String description, String additionnalInformation, Boolean isImportant, Date startDate, Date endDate, double price, int participantNbMax, Boolean isPrivate) {
        setTitle(title);
        setDescription(description);
        setAdditionnalInformation(additionnalInformation);
        setImportant(isImportant);
        setStartDate(startDate);
        setEndDate(endDate);
        setPrice(price);
        setParticipantNbMax(participantNbMax);
        setPrivate(isPrivate);
    }

    public EventModel(int idEvent, String title, String description, String additionnalInformation, Boolean isImportant, Date startDate, Date endDate, double price, int participantNbMax, Boolean isPrivate) {
        this(title, description, additionnalInformation, isImportant, startDate, endDate, price, participantNbMax, isPrivate);
        setIdEvent(idEvent);
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdditionnalInformation() {
        return additionnalInformation;
    }

    public void setAdditionnalInformation(String additionnalInformation) {
        this.additionnalInformation = additionnalInformation;
    }

    public Boolean getImportant() {
        return isImportant;
    }

    public void setImportant(Boolean important) {
        isImportant = important;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getParticipantNbMax() {
        return participantNbMax;
    }

    public void setParticipantNbMax(int participantNbMax) {
        this.participantNbMax = participantNbMax;
    }

    public Boolean getPrivate() {
        return isPrivate;
    }

    public void setPrivate(Boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public int getFk_creator() {
        return fk_creator;
    }

    public void setFk_creator(int fk_creator) {
        this.fk_creator = fk_creator;
    }

    public int getFk_eventType() {
        return fk_eventType;
    }

    public void setFk_eventType(int fk_eventType) {
        this.fk_eventType = fk_eventType;
    }

    public int getFk_address() {
        return fk_address;
    }

    public void setFk_address(int fk_address) {
        this.fk_address = fk_address;
    }
}
