package UI.listener.CRUD;

import UI.listener.Menu.EventCreateListener;
import UI.window.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancelListener implements ActionListener {

    private MainWindow mainWindow;

    public CancelListener(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        EventCreateListener eventCreateListener = new EventCreateListener(mainWindow);
        eventCreateListener.actionPerformed(e);
    }
}
