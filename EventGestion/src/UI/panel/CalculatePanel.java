package UI.panel;

import UI.listener.Business.CalculateListener;
import UI.listener.CRUD.VerificationIntegerListener;
import UI.listener.CRUD.VerificationDoubleListener;
import UI.window.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CalculatePanel extends JPanel {

    private JLabel numberPersonLabel, priceLabel;

    private JTextField priceField, numberPersonField;

    private JButton calculateButton, plusButton;
    private JPanel panel, listButtonPanel;
    private ArrayList <ReductionPanel> jPanelArrayList;

   private MainWindow mainWindow;

    public CalculatePanel(MainWindow mainWindow) {

        //TODO : mainWindow
        this.mainWindow = mainWindow;

        this.setLayout(new GridBagLayout());

        jPanelArrayList = new ArrayList<>();

        panel = new JPanel();
        panel.setLayout(new GridLayout(17,1,10,10));
        listButtonPanel = new JPanel();
        listButtonPanel.setLayout(new GridBagLayout());

        numberPersonLabel = new JLabel("Nombre de participant (ex: 100) : ");
        priceLabel = new JLabel("Price of event (ex: 9.99) : ");


        numberPersonField = new JTextField();
        numberPersonField.addKeyListener(new VerificationIntegerListener(numberPersonField));

        priceField = new JTextField();
        priceField.addKeyListener(new VerificationDoubleListener(priceField));

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateListener(this, mainWindow));

        plusButton = new JButton("+");
        plusButton.addActionListener(new plusListener(this));

        panel.add(numberPersonLabel);
        panel.add(numberPersonField);
        panel.add(priceLabel);
        panel.add(priceField);

        listButtonPanel.add(calculateButton);
        listButtonPanel.add(new JLabel("     "));
        listButtonPanel.add(plusButton);

        addJPanel();
        viewPanel();

       this.add(panel);
    }

    public void addJPanel() {
        if(jPanelArrayList.size() < 10) {
            ReductionPanel reductionPanel = new ReductionPanel();
            jPanelArrayList.add(reductionPanel);
        } else {
            JOptionPane.showMessageDialog(this, "No more reduction", "Information", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private void viewPanel() {
        for(ReductionPanel p : jPanelArrayList) {
                panel.add(p);
        }

        panel.add(listButtonPanel);
    }

    public String getNumberPersonSTR() {
        return numberPersonField.getText().trim();
    }

    public String getPriceSTR() {
        return priceField.getText().trim();
    }

    public ArrayList<ReductionPanel> getListPanel() {
        return jPanelArrayList;
    }

    public void refresh() {
        mainWindow.getFrameContainer().removeAll();
        mainWindow.getFrameContainer().add(this);
        mainWindow.printAll(mainWindow.getGraphics());
    }

    private static class plusListener implements ActionListener {

        private CalculatePanel calculatePanel;

        public plusListener(CalculatePanel calculatePanel) {
            this.calculatePanel = calculatePanel;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            calculatePanel.addJPanel();
            calculatePanel.viewPanel();
            calculatePanel.refresh();
        }
    }
}
