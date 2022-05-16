package Exceptions;

public class UpdateEventException extends Exception {

    public UpdateEventException(){}

    public String getMessage() {
        return "Update event failed";
    }
}
