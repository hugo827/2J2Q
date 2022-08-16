package exception;

public class AddUserException extends Throwable {
    public AddUserException() {}

    public String getMessage(){
        return "User creation failed";
    }
}
