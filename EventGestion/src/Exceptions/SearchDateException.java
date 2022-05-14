package Exceptions;

public class SearchDateException extends Exception {

    public SearchDateException() {}

    public String getMessage(){
        return "The start date can't be after the end date for your search\n And \n Start date and end date can't be null";
    }


}
