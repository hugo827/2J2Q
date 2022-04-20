package Models;

import java.util.GregorianCalendar;

public class EventModel {

    private int idEvent;
    private String title;
    private String description;
    private String additionnalInformation;
    private Boolean isImportant;
    private GregorianCalendar startDate;
    private GregorianCalendar endDate;
    private int price;
    private int participantNbMax;
    private Boolean isPrivate;

    public EventModel(int idEvent, String title, String description, String additionnalInformation, Boolean isImportant, GregorianCalendar startDate, GregorianCalendar endDate, int price, int participantNbMax, Boolean isPrivate) {
        setIdEvent(idEvent);
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

    public GregorianCalendar getStartDate() {
        return startDate;
    }

    public void setStartDate(GregorianCalendar startDate) {
        this.startDate = startDate;
    }

    public GregorianCalendar getEndDate() {
        return endDate;
    }

    public void setEndDate(GregorianCalendar endDate) {
        this.endDate = endDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
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
}
