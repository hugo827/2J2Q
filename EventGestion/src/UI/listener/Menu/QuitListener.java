package UI.listener.Menu;


import UI.window.MainWindow;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class QuitListener implements MouseListener {

    private MainWindow mainWindow;

    public  QuitListener(MainWindow mainWindow){this.mainWindow=mainWindow;}

    public void mouseClicked(MouseEvent e){
        System.exit(0);
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
