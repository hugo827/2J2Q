package Exceptions;

public class SearchDateException extends Exception {

    public SearchDateException() {}

    public String getMessage(){
        return "The start date can't be after the end date for your search";
    }


}
