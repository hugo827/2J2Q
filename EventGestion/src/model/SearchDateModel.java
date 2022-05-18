package model;


import java.util.Date;

public class SearchDateModel {

    private String title;
    private Date startDate;
    private Boolean isPrivate;
    private String fullAddress;

    public SearchDateModel(String title, Date startDate, Boolean isPrivate, String fullAddress) {
        this.title = title;
        this.startDate = startDate;
        this.isPrivate = isPrivate;
        this.fullAddress = fullAddress;
    }

    public String getTitle() {
        return title;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Boolean getPrivate() {
        return isPrivate;
    }

    public String getFullAddress() {
        return fullAddress;
    }

}
