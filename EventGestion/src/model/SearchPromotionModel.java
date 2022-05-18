package model;

import java.util.Date;


public class SearchPromotionModel {

    private Double reduction;
    private String title;
    private Date startDate;
    private Date endDate;
    private Double finalPrice;
    private String eventTypeName;

    public SearchPromotionModel(Double reduction, String title, Date startDate, Date endDate, Double finalPrice, String eventTypeName) {
        this.reduction = reduction;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.finalPrice = finalPrice;
        this.eventTypeName = eventTypeName;
    }

    public Double getReduction() {
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

    public Double getFinalPrice() {
        return finalPrice;
    }

    public String getEventTypeName() {
        return eventTypeName;
    }

}
