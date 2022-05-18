package UI.listener.Menu;


import UI.panel.EventFormPanel;
import UI.window.MainWindow;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventCreateListener implements ActionListener {

    private MainWindow mainWindow;

    public EventCreateListener(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        mainWindow.setTitle("Events Management - Add new event");
        mainWindow.getFrameContainer().removeAll();
        mainWindow.getFrameContainer().add(new EventFormPanel(), BorderLayout.CENTER);
        mainWindow.printAll(mainWindow.getGraphics());
    }

}
