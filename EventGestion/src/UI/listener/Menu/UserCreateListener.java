package UI.listener.Menu;

import UI.panel.UserFormPanel;
import UI.window.MainWindow;
import exception.DataAccessException;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserCreateListener implements ActionListener {

    private MainWindow mainWindow;

    public UserCreateListener(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            mainWindow.setTitle("Events Management - Add new user");
            mainWindow.getFrameContainer().removeAll();
            mainWindow.getFrameContainer().add(new UserFormPanel(mainWindow), BorderLayout.CENTER);
        } catch (DataAccessException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        mainWindow.printAll(mainWindow.getGraphics());
    }

}
