package exception;

public class CalculateReductionException extends Exception {

    public CalculateReductionException() {
    }

    public String getMessage() {
        return "An error occur, check that all reduction fields are completed";
    }
}
