package UI.Listeners.Search;

import UI.Panels.BusinessTaskPanel;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculateListener implements ActionListener {

    private BusinessTaskPanel businessTaskPanel;

    public CalculateListener(BusinessTaskPanel businessTaskPanel) {
        this.businessTaskPanel = businessTaskPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       businessTaskPanel.showInformation();
    }
}
