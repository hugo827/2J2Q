package UI.Listeners.Menu;

import UI.Panels.BusinessTaskPanel;
import UI.Panels.CalculatePanel;
import UI.Windows.MainWindow;

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

        MainWindow.refreshPanel(new BusinessTaskPanel(), "Business task");
//        mainWindow.setTitle("Events Management - Business task");
//        mainWindow.getFrameContainer().removeAll();
//        mainWindow.getFrameContainer().setLayout(new BorderLayout());
//        mainWindow.getFrameContainer().add(new BusinessTaskPanel(), BorderLayout.CENTER);
//        mainWindow.repaint();
//        mainWindow.printAll(mainWindow.getGraphics());
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
