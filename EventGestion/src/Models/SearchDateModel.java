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

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Boolean getPrivate() {
        return isPrivate;
    }

    public void setPrivate(Boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public String getAddressComplet() {
        return addressComplet;
    }

    public void setAddressComplet(String addressComplet) {
        this.addressComplet = addressComplet;
    }
}
