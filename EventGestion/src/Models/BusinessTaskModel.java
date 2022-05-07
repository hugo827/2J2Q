package Models;

public class BusinessTaskModel {

    private int nbParticpant;
    private double sumFinal;
    private double sumTotalWithOutPromotion;
    private double sumTotalPromotion;

    public BusinessTaskModel(int nbParticpant, double sumFinal, double sumTotalWithOutPromotion, double sumTotalPromotion) {
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
