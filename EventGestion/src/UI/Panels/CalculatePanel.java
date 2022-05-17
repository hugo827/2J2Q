package UI.Panels;

import UI.Listeners.Business.CalculateListener;
import UI.Listeners.CRUD.VerificationNbParticipantsListener;
import UI.Listeners.CRUD.VerificationPriceListener;
import UI.Windows.MainWindow;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;

public class CalculatePanel extends JPanel {

    private JLabel numberPersonLabel, priceLabel;

    private JTextField priceField, numberPersonField;

    private JButton calculateButton, plusButton;
    private JPanel panel, listButtonPanel;
    private ArrayList <TestPanel> jPanelArrayList;

    public CalculatePanel() {
        this.setLayout(new GridBagLayout());

        jPanelArrayList = new ArrayList<>();

        panel = new JPanel();
        panel.setLayout(new GridLayout(17,1,10,10));
        listButtonPanel = new JPanel();
        listButtonPanel.setLayout(new GridBagLayout());

        numberPersonLabel = new JLabel("Nombre de participant (ex: 100) : ");
        priceLabel = new JLabel("Price of event (ex: 9.99) : ");


        numberPersonField = new JTextField();
        numberPersonField.addKeyListener(new VerificationNbParticipantsListener(numberPersonField));

        priceField = new JTextField();
        priceField.addKeyListener(new VerificationPriceListener(priceField));

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateListener(this));

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
            TestPanel testPanel = new TestPanel();
            jPanelArrayList.add(testPanel);
        } else {
            JOptionPane.showMessageDialog(this, "No more reduction", "Information", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private void viewPanel() {
        for(TestPanel p : jPanelArrayList) {
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

    public ArrayList<TestPanel> getListPanel() {
        return jPanelArrayList;
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
            MainWindow.refreshPanel(calculatePanel, "Calculate");
        }
    }
}
