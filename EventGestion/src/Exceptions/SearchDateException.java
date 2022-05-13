package Exceptions;

public class SearchDateException extends Exception {

    public SearchDateException() {}

    public String getMessage(){
        return "the start date can't be after the end date";
    }


}
