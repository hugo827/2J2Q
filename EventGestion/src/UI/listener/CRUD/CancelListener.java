package UI.listener.CRUD;

import UI.listener.Menu.EventCreateListener;
import UI.window.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancelListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        EventCreateListener eventCreateListener = new EventCreateListener(MainWindow.getInstance());
        eventCreateListener.actionPerformed(e);
    }
}
