package Models;


import java.util.Date;

public class SearchDateModel {

    private String title;
    private Date startDate;
    private Boolean isPrivate;
    private String addressComplet;

    public SearchDateModel(String title, Date startDate, Boolean isPrivate, String addressComplet) {
        this.title = title;
        this.startDate = startDate;
        this.isPrivate = isPrivate;
        this.addressComplet = addressComplet;
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

    public String getAddressComplet() {
        return addressComplet;
    }

}
