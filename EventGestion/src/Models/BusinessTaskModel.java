package Models;

public class BusinessTaskModel {

    private int nbParticpant;
    private double sumTotal;
    private double sumTotalWithOutPromotion;
    private double sumTotalPromotion;

    public BusinessTaskModel(int nbParticpant, double sumTotal, double sumTotalWithOutPromotion, double sumTotalPromotion) {
        this.nbParticpant = nbParticpant;
        this.sumTotal = sumTotal;
        this.sumTotalWithOutPromotion = sumTotalWithOutPromotion;
        this.sumTotalPromotion = sumTotalPromotion;
    }

    public int getNbParticpant() {
        return nbParticpant;
    }

    public void setNbParticpant(int nbParticpant) {
        this.nbParticpant = nbParticpant;
    }

    public double getSumTotal() {
        return sumTotal;
    }

    public void setSumTotal(double sumTotal) {
        this.sumTotal = sumTotal;
    }

    public double getSumTotalWithOutPromotion() {
        return sumTotalWithOutPromotion;
    }

    public void setSumTotalWithOutPromotion(double sumTotalWithOutPromotion) {
        this.sumTotalWithOutPromotion = sumTotalWithOutPromotion;
    }

    public double getSumTotalPromotion() {
        return sumTotalPromotion;
    }

    public void setSumTotalPromotion(double sumTotalPromotion) {
        this.sumTotalPromotion = sumTotalPromotion;
    }
}
