package UI.listener.Menu;


import UI.panel.EventFormPanel;
import UI.window.MainWindow;
import exception.DataAccessException;


import javax.swing.*;
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
        try {
            mainWindow.setTitle("Events Management - Add new event");
            mainWindow.getFrameContainer().removeAll();
            mainWindow.getFrameContainer().add(new EventFormPanel(mainWindow), BorderLayout.CENTER);
        } catch (DataAccessException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        mainWindow.printAll(mainWindow.getGraphics());
    }

}
