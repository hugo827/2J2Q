package exception;

public class UpdateEventException extends Exception {

    public UpdateEventException(){}

    public String getMessage() {
        return "Event update failed";
    }
}
