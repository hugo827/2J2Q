package UI.Listeners;

import UI.Panels.BusinessTaskPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SelectUserListener implements MouseListener {

    private BusinessTaskPanel businessTaskPanel;

    public SelectUserListener(BusinessTaskPanel businessTaskPanel) {
        this.businessTaskPanel = businessTaskPanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("select");
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
