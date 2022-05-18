package model;

import exception.EventException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EventModel {

    private Integer idEvent;
    private String title;
    private String description;
    private String additionalInformation;
    private Boolean isImportant;
    private Date startDate;
    private Date endDate;
    private Double price;
    private Integer participantNbMax;
    private Boolean isPrivate;
    private Integer fk_creator, fk_eventType, fk_address;
    private String creator, eventtype, address;
    private final SimpleDateFormat format = new SimpleDateFormat(" dd MMM yyyy 'at' HH:mm");

    public EventModel(String title, String description, String additionalInformation, Boolean isImportant, Date startDate, Date endDate, Double price, Integer participantNbMax, Boolean isPrivate, Integer fk_creator, Integer fk_eventType, Integer fk_address) throws EventException {
        setTitle(title);
        setDescription(description);
        setAdditionalInformation(additionalInformation);
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

    public EventModel(Integer idEvent, String title, String description, String additionalInformation, Boolean isImportant, Date startDate, Date endDate, Double price, Integer participantNbMax, Boolean isPrivate, Integer fk_creator, Integer fk_eventType, Integer fk_address) throws EventException {
        this(title, description, additionalInformation, isImportant, startDate, endDate, price, participantNbMax, isPrivate, fk_creator, fk_eventType, fk_address);
        setIdEvent(idEvent);
    }

    public EventModel(Integer idEvent, String title, String description, String additionalInformation, Boolean isImportant, Date startDate, Date endDate, Double price, Integer participantNbMax, Boolean isPrivate, Integer fk_creator, Integer fk_eventType, Integer fk_address, String creator, String address, String eventType) throws EventException {
        this(idEvent, title, description, additionalInformation, isImportant, startDate, endDate, price, participantNbMax, isPrivate, fk_creator, fk_eventType, fk_address);
        setAddress(address);
        setCreator(creator);
        setEventtype(eventType);
    }


    public Integer getIdEvent() {
        return idEvent;
    }

    private void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws EventException {
        if(title == null || title.trim().isEmpty()) {
           throw new EventException("Title can't be null", "Error event title");
        } else {
            this.title = title;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) throws EventException {
        if(description == null || description.trim().isEmpty()) {
            throw new EventException("Description can't be null", "Error event description");
        } else {
            this.description = description;
        }
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        if(additionalInformation != null && additionalInformation.trim().isEmpty()) additionalInformation = null;
        this.additionalInformation = additionalInformation;
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

    public String getStartDateSTR() {
        return format.format(startDate);
    }

    public void setStartDate(Date startDate) throws EventException {
        if(startDate == null) {
            throw new EventException("Start date is required", "Error event");
        } else {
            this.startDate = startDate;
        }
    }

    public Date getEndDate() {
        return endDate;
    }
    public String getEndDateSTR() {
        return format.format(endDate);
    }

    public void setEndDate(Date endDate) throws EventException {
        if(endDate == null || (startDate != null && endDate.before(startDate) ) ) {
            throw new EventException("Event end date can't be null and can't be before start date", "Error event");
        } else {
            this.endDate = endDate;
        }
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(double price) throws EventException {
        if(price < 0.) {
            throw new EventException("Price can't be negative", "Error event");
        } else {
            this.price = price;
        }
    }

    public void setPrice(String priceSTR) throws EventException {
        if(priceSTR == null || priceSTR.trim().isEmpty()) {
            throw new EventException("Price can't be null", "Error event");
        } else {
            try {
                setPrice(Double.parseDouble(priceSTR));
            } catch (NumberFormatException  eventException) {
                throw new EventException(eventException.getMessage(), "Error event");
            }

        }
    }

    public Integer getParticipantNbMax() {
        return participantNbMax;
    }

    public void setParticipantNbMax(int participantNbMax) throws EventException {
        if(participantNbMax < 0) {
            throw new EventException("Number of participant can't be negative", "Error event");
        } else {
            this.participantNbMax = participantNbMax;
        }
    }

    public void setParticipantNbMax(String participantNbMaxSTR) throws EventException {
        if(participantNbMaxSTR == null || participantNbMaxSTR.trim().isEmpty()) {
            throw new EventException("Number of participant can't be null", "Error event");
        } else {
            try {
                setParticipantNbMax( Integer.parseInt(participantNbMaxSTR) );
            } catch (NumberFormatException  eventException) {
                throw new EventException(eventException.getMessage(), "Error event");
            }
        }
    }

    public Boolean getPrivate() {
        return isPrivate;
    }

    public void setPrivate(Boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public Integer getFk_creator() {
        return fk_creator;
    }

    public void setFk_creator(int fk_creator) throws EventException {
        if(fk_creator <= 0) {
            throw new EventException("Creator is required", "Error event");
        } else {
            this.fk_creator = fk_creator;
        }
    }

    public Integer getFk_eventType() {
        return fk_eventType;
    }

    public void setFk_eventType(int fk_eventType) throws EventException {
        if(fk_eventType <= 0) {
            throw new EventException("Event type is required", "Error event");
        } else {
            this.fk_eventType = fk_eventType;
        }
    }

    public Integer getFk_address() {
        return fk_address;
    }

    public void setFk_address(int fk_address) throws EventException {
        if(fk_address <= 0) {
            throw new EventException("Event address is required ", "Error event fk_address ");
        } else {
            this.fk_address = fk_address;
        }
    }

    public String getCreator() {
        return creator;
    }

    public String getEventtype() {
        return eventtype;
    }

    public String getAddress() {
        return address;
    }

    private void setCreator(String creator) {
        this.creator = creator;
    }

    private void setEventtype(String eventtype) {
        this.eventtype = eventtype;
    }

    private void setAddress(String address) {
        this.address = address;
    }


}
