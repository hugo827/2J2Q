package UI.listener.Business;

import UI.panel.CalculatePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddReductionPanelListener implements ActionListener {

    private CalculatePanel calculatePanel;

    public AddReductionPanelListener(CalculatePanel calculatePanel) {
        this.calculatePanel = calculatePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        calculatePanel.addJPanel();
        calculatePanel.viewPanel();
        calculatePanel.refresh();
    }
}