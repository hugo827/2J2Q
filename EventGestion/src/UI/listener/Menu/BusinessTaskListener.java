package UI.listener.Menu;

import UI.panel.BusinessTaskPanel;
import UI.window.MainWindow;
import exception.DataAccessException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class BusinessTaskListener implements MouseListener {

    private MainWindow mainWindow;

    public BusinessTaskListener(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }
    @Override
    public void mouseClicked(MouseEvent e) {

        try {
            mainWindow.setTitle("Events Management - Business task");
            mainWindow.getFrameContainer().removeAll();
            mainWindow.getFrameContainer().add(new BusinessTaskPanel(mainWindow), BorderLayout.CENTER);
            mainWindow.printAll(mainWindow.getGraphics());
        } catch (DataAccessException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseClicked(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
