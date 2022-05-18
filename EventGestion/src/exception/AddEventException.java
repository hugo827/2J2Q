package exception;

public class AddEventException extends Exception {

    public AddEventException() {}

    public String getMessage(){
        return "Event creation failed";
    }
}
