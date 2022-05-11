package Exceptions;

public class DateException  extends Exception{
    //String car la date encodée n'est pas forcément une date
    //a utiliser si date invalide ou trop tot dans le temps ou format invalide
    private String dateInvalide;

    public DateException(String dateInvalide){
        this.dateInvalide=dateInvalide;
    }

    public String getMessage(){
        return "La valeur: "+dateInvalide+", n'est pas une date au format valide.";
    }
}
