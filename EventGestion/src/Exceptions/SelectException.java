package Exceptions;

public class SelectException extends  Exception {

    public SelectException() {}

    public String getMessage() {
        return "Data search failed";
    }
}
