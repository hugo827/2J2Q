package UI.Listeners.CRUD;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class VerificationPriceListener implements KeyListener {

    private JTextField jTextField;

    public VerificationPriceListener(JTextField jTextField) {
        this.jTextField = jTextField;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if( (e.getKeyChar() >= '0'  && e.getKeyChar() <= '9')
                || (e.getKeyChar() == '.' && !jTextField.getText().trim().contains(".") && !jTextField.getText().trim().isEmpty())
                || e.getKeyChar() == KeyEvent.VK_BACK_SPACE || e.getKeyChar() == KeyEvent.VK_DELETE ) {
            jTextField.setEditable(true);
        } else {
            jTextField.setEditable(false);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
