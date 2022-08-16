package exception;

public class NumberPersonException extends Exception {

    private int totalPerson, totalPersonHavePromotion;

    public NumberPersonException(int totalPerson, int totalPersonHavePromotion) {
        this.totalPerson =totalPerson;
        this.totalPersonHavePromotion = totalPersonHavePromotion;
    }

    public String getMessage() {
        return  totalPersonHavePromotion + " persons obtained a reduction, this number is higher than total participant at the event : " + totalPerson;
    }
}
