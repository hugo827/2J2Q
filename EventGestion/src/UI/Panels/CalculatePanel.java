package UI.Panels;

import UI.Listeners.Business.CalculateListener;
import UI.Listeners.CRUD.VerificationNbParticipantsListener;
import UI.Listeners.CRUD.VerificationPriceListener;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.NumberFormat;

public class CalculatePanel extends JPanel {

    private JLabel label, numberPersonLabel, reducLabel, priceLabel;

    private JTextField reducField, priceField, numberPersonField;

    private JButton calculateButton;
    private JPanel panel;

    public CalculatePanel() {
        this.setLayout(new GridBagLayout());

        panel = new JPanel();
        panel.setLayout(new GridLayout(4,2,10,10));

        numberPersonLabel = new JLabel("Nombre de participant (ex: 100) : ");
        reducLabel = new JLabel("Reduction en % (ex: 10) : ");
        priceLabel = new JLabel("Price of event (ex: 9.99) : ");


        numberPersonField = new JTextField();
        numberPersonField.addKeyListener(new VerificationNbParticipantsListener(numberPersonField));

        reducField = new JTextField();
        reducField.addKeyListener(new VerificationNbParticipantsListener(reducField));

        priceField = new JTextField();
        priceField.addKeyListener(new VerificationPriceListener(priceField));

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateListener(this));

        panel.add(numberPersonLabel);
        panel.add(numberPersonField);
        panel.add(reducLabel);
        panel.add(reducField);
        panel.add(priceLabel);
        panel.add(priceField);
        panel.add(calculateButton);

       this.add(panel);
    }

    public String getNumberPersonSTR() {
        return numberPersonField.getText().trim();
    }

    public String getReducSTR() {
        return  reducField.getText().trim();
    }

    public String getPriceSTR() {
        return priceField.getText().trim();
    }
}
