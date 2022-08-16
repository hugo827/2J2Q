package exception;

import java.util.Date;

public class SearchDateException extends Exception {

    Date startDate, endDate;
    public SearchDateException(Date startDate, Date endDate) {
       this.startDate = startDate;
       this.endDate = endDate;
    }

    public String getMessage(){
        String message;

        if(startDate == null) {
            message = "Start date can't be null, please enter a valid date";
        } else {
            if(endDate == null) {
                message = "End date can't be null, please enter a valid end date";
            } else {
                if(endDate.before(startDate)) {
                    message = "Start date can't be before the end date";
                } else {
                    message = "Unknow error";
                }
            }
        }
        return  message;
    }


}
