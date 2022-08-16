package UI.listener.Menu;

import UI.panel.SearchPromotionPanel;
import UI.window.MainWindow;
import exception.DataAccessException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchPromotionListener implements ActionListener {

    private MainWindow mainWindow;

    public SearchPromotionListener(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            mainWindow.setTitle("Events Management - Search promotions");
            mainWindow.getFrameContainer().removeAll();
            mainWindow.getFrameContainer().add(new SearchPromotionPanel(mainWindow), BorderLayout.CENTER);
            mainWindow.repaint();
            mainWindow.printAll(mainWindow.getGraphics());
        } catch (DataAccessException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
