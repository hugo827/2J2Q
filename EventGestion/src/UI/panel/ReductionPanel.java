package UI.panel;

import UI.listener.CRUD.VerificationIntegerListener;
import UI.listener.CRUD.VerificationDoubleListener;

import javax.swing.*;
import java.awt.*;

public class ReductionPanel extends JPanel {

    private JTextField numberPersonField, reducField;

    public ReductionPanel() {
        this.setLayout(new GridLayout(1, 4, 5, 5));
        JLabel numberPersonLabel = new JLabel("Number of people who have a discount : ");
        JLabel reducLabel = new JLabel("Pourcent Reduction (ex: 12.50) : ");
        numberPersonField = new JTextField();
        numberPersonField.addKeyListener(new VerificationIntegerListener(numberPersonField));

        reducField = new JTextField();
        reducField.addKeyListener(new VerificationDoubleListener(reducField));

        this.add(numberPersonLabel);
        this.add(numberPersonField);
        this.add(reducLabel);
        this.add(reducField);
    }

    public String getNumberPersonField() {
        return numberPersonField.getText().trim();
    }

    public String getReducField() {
        return reducField.getText().trim();
    }
}
