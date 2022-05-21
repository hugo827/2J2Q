package UI.listener.Menu;


import UI.panel.EventListingPanel;
import UI.window.MainWindow;
import exception.DataAccessException;

import javax.swing.*;
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

        try {
            mainWindow.setTitle("Events Management - Listing Event");
            mainWindow.getFrameContainer().removeAll();
            mainWindow.getFrameContainer().add(new EventListingPanel(mainWindow), BorderLayout.CENTER);
            mainWindow.printAll(mainWindow.getGraphics());
        } catch (DataAccessException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }
}
