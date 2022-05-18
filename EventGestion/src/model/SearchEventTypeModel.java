package model;

import java.text.SimpleDateFormat;
import java.util.Date;


public class SearchEventTypeModel {

    private String title;
    private Date startDate;
    private Date endDate;
    private String firstName;
    private String lastName;
    private String name;
    private final static SimpleDateFormat format = new SimpleDateFormat(" dd MMM yyyy 'at' HH:mm");

    public SearchEventTypeModel(String title, Date startDate, Date endDate, String firstName, String lastName, String name) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public Date getStartDate() {
        return startDate;
    }
    public String getStartDateSTR() {
        return format.format(startDate);
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getEndDateSTR() { return format.format(endDate); }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }


}
