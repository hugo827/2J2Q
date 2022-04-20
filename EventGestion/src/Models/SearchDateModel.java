package Models;

import java.util.GregorianCalendar;

public class SearchDateModel {

    private String title;
    private GregorianCalendar startDate;
    private GregorianCalendar endDate;
    private Boolean isPrivate;
    private String addressComplet;

    public SearchDateModel(String title, GregorianCalendar startDate, GregorianCalendar endDate, Boolean isPrivate, String addressComplet) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isPrivate = isPrivate;
        this.addressComplet = addressComplet;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
