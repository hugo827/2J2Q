package Models;

public class BusinessTaskModel {

    private Integer nbParticipant;
    private Double sumFinal;
    private Double sumTotalWithOutPromotion;
    private Double sumTotalPromotion;

    public BusinessTaskModel(Integer nbParticipant, Double sumFinal, Double sumTotalWithOutPromotion, Double sumTotalPromotion) {
        this.nbParticipant = nbParticipant;
        this.sumFinal = sumFinal;
        this.sumTotalWithOutPromotion = sumTotalWithOutPromotion;
        this.sumTotalPromotion = sumTotalPromotion;
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


}
