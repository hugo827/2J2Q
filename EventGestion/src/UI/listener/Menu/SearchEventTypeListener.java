package UI.listener.Menu;

import UI.panel.SearchEventTypePanel;
import UI.window.MainWindow;
import exception.DataAccessException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchEventTypeListener implements ActionListener {

    private MainWindow mainWindow;

    public SearchEventTypeListener(MainWindow mainWindow) {
        this.mainWindow = mainWindow;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            mainWindow.setTitle("Events Management - Search By Event Type");
            mainWindow.getFrameContainer().removeAll();
            mainWindow.getFrameContainer().add(new SearchEventTypePanel(mainWindow), BorderLayout.CENTER);
        } catch (DataAccessException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        mainWindow.printAll(mainWindow.getGraphics());
    }
}
