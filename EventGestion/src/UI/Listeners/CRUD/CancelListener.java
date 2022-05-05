package UI.Listeners.CRUD;

import UI.Listeners.Menu.EventCreateListener;
import UI.Windows.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancelListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        EventCreateListener eventCreateListener = new EventCreateListener(MainWindow.getMainWindow());
        eventCreateListener.actionPerformed(e);
    }
}
