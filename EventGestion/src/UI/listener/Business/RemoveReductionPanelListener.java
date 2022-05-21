package UI.listener.Business;


import UI.panel.CalculatePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveReductionPanelListener implements ActionListener {

    private CalculatePanel calculatePanel;

    public RemoveReductionPanelListener(CalculatePanel calculatePanel) {
        this.calculatePanel = calculatePanel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        calculatePanel.removePanel();
        calculatePanel.viewPanel();
        calculatePanel.refresh();
    }
}
