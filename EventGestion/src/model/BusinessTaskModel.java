package model;

public class BusinessTaskModel {

    private Integer nbParticipant;
    private Double sumFinal;
    private Double sumTotalWithOutPromotion;
    private Double sumTotalPromotion;

    private Integer totalPersonHavePromotion;

    public BusinessTaskModel(Integer nbParticipant, Double sumFinal, Double sumTotalWithOutPromotion, Double sumTotalPromotion) {
        this.nbParticipant = nbParticipant;
        this.sumFinal = sumFinal;
        this.sumTotalWithOutPromotion = sumTotalWithOutPromotion;
        this.sumTotalPromotion = sumTotalPromotion;
    }

    public BusinessTaskModel(Integer nbParticipant, Double sumFinal, Double sumTotalWithOutPromotion, Double sumTotalPromotion, Integer totalPersonHavePromotion) {
        this(nbParticipant,sumFinal,sumTotalWithOutPromotion,sumTotalPromotion);
        this.totalPersonHavePromotion = totalPersonHavePromotion;
    }

    public Integer getNbParticipant() {
        return nbParticipant;
    }

    public Double getSumFinal() {
        return sumFinal;
    }

    public Double getSumTotalWithOutPromotion() {
        return sumTotalWithOutPromotion;
    }


    public Double getSumTotalPromotion() {
        return sumTotalPromotion;
    }

    public Integer getTotalPersonHavePromotion() {
        return totalPersonHavePromotion;
    }
}
