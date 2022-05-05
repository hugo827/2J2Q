package UI.animation;

import java.awt.*;

public class ChangeDate {

    private String[] months = {"January", "Ferbruary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
    private String[] daysNames = { "Monday", "Tuesday","Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
    private int indMonth = 0;
    private int indDay = 0;
    private int numberOfDayMonth;

    public ChangeDate() {
        numberOfDayMonth = 1;
    }

    public void changeDate() {
        switch(indMonth) {
            case 0,2,4,6,8,10,12 :
                if(numberOfDayMonth < 31) numberOfDayMonth++;
                else changeMonth();
                break;
            case 3,5,7,9,11 :
                if(numberOfDayMonth < 30) numberOfDayMonth++;
                else changeMonth();
                break;
            case 1 :
                if(numberOfDayMonth < 28) numberOfDayMonth++;
                else changeMonth();
                break;
        }
        if(indDay >= daysNames.length - 1) indDay = 0;
        else indDay++;
    }

    private void changeMonth() {
        if(indMonth >= months.length - 1) indMonth = 0;
        else indMonth++;
        numberOfDayMonth = 1;
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawString("" + months[indMonth], 25,22);
        g.drawString("" + daysNames[indDay], 15,50);
        g.setColor(Color.RED);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 35));
        if(numberOfDayMonth >= 10)  g.drawString("" + numberOfDayMonth + "", 25, 85 );
        else g.drawString("" + numberOfDayMonth + "", 35, 85 );
    }
}
