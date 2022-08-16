package exception;

public class EventException extends Exception {

    private String error, message;

    public EventException(String message, String errorTitle) {
        this.message = message;
        this.error = errorTitle;
    }

   public String getMessage(){
       return message;
   }

   public String getTitleError() {
        return error;
    }
}
