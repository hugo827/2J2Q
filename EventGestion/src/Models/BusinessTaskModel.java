package Models;

public class BusinessTaskModel {

    private Integer nbParticpant;
    private Double sumFinal;
    private Double sumTotalWithOutPromotion;
    private Double sumTotalPromotion;

    public BusinessTaskModel(Integer nbParticpant, Double sumFinal, Double sumTotalWithOutPromotion, Double sumTotalPromotion) {
        this.nbParticpant = nbParticpant;
        this.sumFinal = sumFinal;
        this.sumTotalWithOutPromotion = sumTotalWithOutPromotion;
        this.sumTotalPromotion = sumTotalPromotion;
    }

    public int getNbParticpant() {
        return nbParticpant;
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
