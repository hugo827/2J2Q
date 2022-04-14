package UI.Listeners;

import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;


public class BusinessTaskListener implements MenuListener {

    @Override
    public void menuSelected(MenuEvent e) {
        System.out.println("BusinessTaskListener");
    }

    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }
}
