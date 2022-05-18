package UI.listener.Business;

import exception.DataAccessException;
import UI.panel.BusinessTaskPanel;

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
        try {
            businessTaskPanel.setNewEventPanel();
        } catch (DataAccessException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
