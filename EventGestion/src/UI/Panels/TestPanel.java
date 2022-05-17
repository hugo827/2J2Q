package UI.Panels;

import UI.Listeners.CRUD.VerificationNbParticipantsListener;

import javax.swing.*;
import java.awt.*;

public class TestPanel extends JPanel {


    private JTextField numberPersonField, reducField;

    public TestPanel() {
        this.setLayout(new GridLayout(1, 4, 5, 5));
        JLabel numberPersonLabel = new JLabel("Nombre de participant (ex: 100) : ");
        JLabel reducLabel = new JLabel("Reduction en % (ex: 10) : ");
        numberPersonField = new JTextField();
        numberPersonField.addKeyListener(new VerificationNbParticipantsListener(numberPersonField));

        reducField = new JTextField();
        reducField.addKeyListener(new VerificationNbParticipantsListener(reducField));

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
