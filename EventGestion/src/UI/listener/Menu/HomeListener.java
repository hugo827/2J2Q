package UI.listener.Menu;


import UI.window.MainWindow;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class HomeListener implements MouseListener {

    private MainWindow mainWindow;
    public HomeListener(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        MainWindow.refreshPanel(null, null);
//        mainWindow.setTitle("Events Management");
//        mainWindow.getFrameContainer().removeAll();
//        mainWindow.getFrameContainer().setLayout(new BorderLayout());
//        mainWindow.getFrameContainer().add(new HomePanel(), BorderLayout.CENTER);
//        mainWindow.repaint();
//        mainWindow.printAll(mainWindow.getGraphics());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseClicked(e);
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
