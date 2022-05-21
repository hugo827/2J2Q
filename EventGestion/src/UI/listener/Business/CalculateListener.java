package UI.listener.Business;

import exception.CalculateReductionException;
import exception.NumberPersonException;
import exception.ReductionBetweenException;
import model.BusinessTaskModel;
import UI.panel.CalculatePanel;
import UI.window.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculateListener implements ActionListener {

    private CalculatePanel calculatePanel;
    private MainWindow mainWindow;
    public CalculateListener(CalculatePanel calculatePanel, MainWindow mainWindow) {
        this.calculatePanel = calculatePanel;
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (calculatePanel.getNumberPersonSTR() == null || calculatePanel.getNumberPersonSTR().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Number of person needed", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (calculatePanel.getPriceSTR() == null || calculatePanel.getPriceSTR().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Price needed", "Error", JOptionPane.ERROR_MESSAGE);
        }  else {
            BusinessTaskModel res = null;
            try {
                res = mainWindow.getEventsManagementController().calculateReduction(Integer.parseInt(calculatePanel.getNumberPersonSTR()),
                       Double.parseDouble(calculatePanel.getPriceSTR()), calculatePanel.getReducList());
                String message = " - Number of participants : " + res.getNbParticipant() + "\n"
                        + " - Number of participants who had a promotion: "  + res.getTotalPersonHavePromotion() + "\n"
                        + " - Total sum : " + res.getSumTotalWithOutPromotion() + "\n"
                        + " - Total promotion : " + res.getSumTotalPromotion() + "\n"
                        + " - Final sum : " + res.getSumFinal() + "\n";
                JOptionPane.showMessageDialog(null, message, "Information", JOptionPane.PLAIN_MESSAGE );

            } catch (CalculateReductionException |ReductionBetweenException | NumberPersonException ex) {
                JOptionPane.showMessageDialog(calculatePanel, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }
}
