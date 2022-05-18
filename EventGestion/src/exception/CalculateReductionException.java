package exception;

public class CalculateReductionException extends Exception {

    public CalculateReductionException() {
    }

    public String getMessage() {
        return "There was an error, make sure all reduction fields are filled out";
    }
}
