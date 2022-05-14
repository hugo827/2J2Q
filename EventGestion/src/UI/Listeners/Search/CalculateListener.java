package UI.Listeners.Search;

import Exceptions.BusinessTaskException;
import UI.Panels.BusinessTaskPanel;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculateListener implements ActionListener {

    private BusinessTaskPanel businessTaskPanel;

    public CalculateListener(BusinessTaskPanel businessTaskPanel) {
        this.businessTaskPanel = businessTaskPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            businessTaskPanel.showInformation();
        } catch (BusinessTaskException ex) {
            JOptionPane.showMessageDialog(businessTaskPanel, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
