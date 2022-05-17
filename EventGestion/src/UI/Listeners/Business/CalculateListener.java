package UI.Listeners.Business;

import UI.Panels.CalculatePanel;
import UI.Windows.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculateListener implements ActionListener {

    CalculatePanel calculatePanel;
    public CalculateListener(CalculatePanel calculatePanel) {
        this.calculatePanel = calculatePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (calculatePanel.getNumberPersonSTR() == null || calculatePanel.getNumberPersonSTR().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Need number of person", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (calculatePanel.getPriceSTR() == null || calculatePanel.getPriceSTR().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Need price", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (calculatePanel.getReducSTR() == null || calculatePanel.getReducSTR().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Need reduc", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            double res = MainWindow.getController().calculateReduction(Integer.parseInt(calculatePanel.getNumberPersonSTR()),
                   Double.parseDouble(calculatePanel.getReducSTR()), Double.parseDouble(calculatePanel.getPriceSTR()));
            JOptionPane.showMessageDialog(null, "La reduction total est de : " + res, "Information", JOptionPane.PLAIN_MESSAGE );

        }
    }
}
