package Exceptions;

public class AddEventException extends Exception {

    public AddEventException() {}


    public String getMessage(){
        return "Adding event failed";
    }
}
