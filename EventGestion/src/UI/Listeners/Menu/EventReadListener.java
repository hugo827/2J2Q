package UI.Listeners.Menu;


import UI.Panels.EventListingPanel;
import UI.Windows.MainWindow;

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
        MainWindow.refreshPanel(new EventListingPanel(), "Listing Event");
//        mainWindow.setTitle("Events Management - Listing Event");
//        mainWindow.getFrameContainer().removeAll();
//        mainWindow.getFrameContainer().setLayout(new BorderLayout());
//        mainWindow.getFrameContainer().add(new EventListingPanel(), BorderLayout.CENTER);
//        mainWindow.repaint();
//        mainWindow.printAll(mainWindow.getGraphics());
    }
}
