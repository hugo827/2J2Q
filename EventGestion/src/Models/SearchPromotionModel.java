package Models;

import java.util.Date;


public class SearchPromotionModel {

    private double reduction;
    private String title;
    private Date startDate;
    private Date endDate;
    private double finalPrice;
    private String eventTypeName;

    public SearchPromotionModel(double reduction, String title, Date startDate, Date endDate, double finalPrice, String eventTypeName) {
        this.reduction = reduction;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.finalPrice = finalPrice;
        this.eventTypeName = eventTypeName;
    }

    public double getReduction() {
        return reduction;
    }

    public String getTitle() {
        return title;
    }

    public Date getStartDate() {
        return startDate;
    }


    public Date getEndDate() {
        return endDate;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public String getEventTypeName() {
        return eventTypeName;
    }

}
