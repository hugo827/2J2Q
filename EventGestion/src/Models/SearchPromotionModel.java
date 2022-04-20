package Models;

import java.util.GregorianCalendar;

public class SearchPromotionModel {

    private double reduction;
    private String title;
    private GregorianCalendar startDate;
    private GregorianCalendar endDate;
    private double finalPrice;
    private String name;

    public SearchPromotionModel(double reduction, String title, GregorianCalendar startDate, GregorianCalendar endDate, double finalPrice, String name) {
        this.reduction = reduction;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.finalPrice = finalPrice;
        this.name = name;
    }

    public double getReduction() {
        return reduction;
    }

    public void setReduction(double reduction) {
        this.reduction = reduction;
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

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
