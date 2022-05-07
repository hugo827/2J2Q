package UI.Listeners.Search;

import UI.Panels.BusinessTaskPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SelectEventListener implements MouseListener {

    private BusinessTaskPanel businessTaskPanel;

    public SelectEventListener(BusinessTaskPanel businessTaskPanel) {
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
            businessTaskPanel.viewButton();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
