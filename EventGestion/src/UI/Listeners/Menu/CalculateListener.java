package UI.Listeners.Menu;

import UI.Panels.CalculatePanel;
import UI.Windows.MainWindow;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CalculateListener implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        MainWindow.refreshPanel(new CalculatePanel(), "Calculate");
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
