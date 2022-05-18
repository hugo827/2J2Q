package exception;

public class ReductionBetweenException extends Exception {
    public ReductionBetweenException() {
    }
    public String getMessage() {
        return "Reduction need to be between 0.1 and 100";
    }
}
