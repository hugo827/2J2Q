package UI.listener.Business;

import exception.CalculateReductionException;
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
            JOptionPane.showMessageDialog(null, "Need number of person", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (calculatePanel.getPriceSTR() == null || calculatePanel.getPriceSTR().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Need price", "Error", JOptionPane.ERROR_MESSAGE);
        }  else {


            BusinessTaskModel res = null;
            try {

                res = mainWindow.getEventsManagementController().calculateReduction(Integer.parseInt(calculatePanel.getNumberPersonSTR()),
                       Double.parseDouble(calculatePanel.getPriceSTR()), calculatePanel.getListPanel());
                String message = " - Nombre de participant : " + res.getNbParticipant() + "\n"
                        + " - Nombre de participant ayant eu une promotion : "  + res.getTotalPersonHavePromotion() + "\n"
                        + " - Somme total : " + res.getSumTotalWithOutPromotion() + "\n"
                        + " - Somme total prommotion : " + res.getSumTotalPromotion() + "\n"
                        + " - Somme final : " + res.getSumFinal() + "\n";
                JOptionPane.showMessageDialog(null, message, "Information", JOptionPane.PLAIN_MESSAGE );

            } catch (CalculateReductionException |ReductionBetweenException  ex) {
                JOptionPane.showMessageDialog(calculatePanel, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }
}
