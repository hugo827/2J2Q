package UI.listener.Menu;


import UI.panel.EventListingPanel;
import UI.window.MainWindow;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventReadListener implements ActionListener {

    private MainWindow mainWindow;

    public EventReadListener(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainWindow.setTitle("Events Management - Listing Event");
        mainWindow.getFrameContainer().removeAll();
        mainWindow.getFrameContainer().add(new EventListingPanel(), BorderLayout.CENTER);
        mainWindow.printAll(mainWindow.getGraphics());
    }
}
