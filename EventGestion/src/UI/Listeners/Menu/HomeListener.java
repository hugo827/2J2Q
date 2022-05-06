package UI.Listeners.Menu;


import UI.Panels.HomePanel;
import UI.Windows.MainWindow;
import UI.animation.AnimationPanel;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class HomeListener implements MouseListener {

    private MainWindow mainWindow;
    private AnimationPanel animationPanel;

    public HomeListener(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        mainWindow.setTitle("Event Gestion");
        mainWindow.getFrameContainer().removeAll();
        mainWindow.getFrameContainer().setLayout(new BorderLayout());
        mainWindow.getFrameContainer().add(new HomePanel(), BorderLayout.CENTER);
        mainWindow.repaint();
        mainWindow.printAll(mainWindow.getGraphics());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}