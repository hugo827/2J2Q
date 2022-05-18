package exception;

public class ReductionBetweenException extends Exception {
    public ReductionBetweenException() {
    }
    public String getMessage() {
        return "The reduction must be between 0 and 100";
    }
}
