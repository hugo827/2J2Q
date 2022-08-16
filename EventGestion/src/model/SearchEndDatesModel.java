package model;


import java.util.Date;

public class SearchEndDatesModel {

    private String eventType;
    private String title;
    private Date startDate;
    private Boolean isImportant;
    private String lastName;
    private String firstName;
    private String userType;

    public SearchEndDatesModel(String eventType,String title,Date startDate,Boolean isImportant,String lastName,String firstName,String userType) {
        this.eventType=eventType;
        this.title=title;
        this.startDate=startDate;
        this.isImportant=isImportant;
        this.lastName=lastName;
        this.firstName=firstName;
        this.userType=userType;
    }

    public String getEventType(){return eventType;}
    public String getTitle() {
        return title;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Boolean getIsImportant() {
        return isImportant;
    }

    public String getLastName() {
        return lastName;
    }
    public String getFirstName(){return firstName;}
    public String getUserType(){return userType;}
}