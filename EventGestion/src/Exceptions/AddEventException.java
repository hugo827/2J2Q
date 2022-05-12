package Exceptions;

public class AddEventException extends Exception {

    public AddEventException() {}


    public String getMessage(){
        return "L'ajout de l'evenement a echoué !";
    }
}
