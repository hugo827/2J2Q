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

    public int getNbParticipant() {
        return nbParticipant;
    }

    public double getSumFinal() {
        return sumFinal;
    }

    public double getSumTotalWithOutPromotion() {
        return sumTotalWithOutPromotion;
    }


    public double getSumTotalPromotion() {
        return sumTotalPromotion;
    }

    public Integer getTotalPersonHavePromotion() {
        return totalPersonHavePromotion;
    }
}
