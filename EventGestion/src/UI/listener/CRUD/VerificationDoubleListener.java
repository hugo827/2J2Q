package UI.listener.CRUD;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class VerificationDoubleListener implements KeyListener {

    private JTextField jTextField;

    public VerificationDoubleListener(JTextField jTextField) {
        this.jTextField = jTextField;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        jTextField.setEditable(
                (e.getKeyChar() >= '0' && e.getKeyChar() <= '9')
                || (e.getKeyChar() == '.' && !jTextField.getText().trim().contains(".") && !jTextField.getText().trim().isEmpty())
                || e.getKeyChar() == KeyEvent.VK_BACK_SPACE
                || e.getKeyChar() == KeyEvent.VK_DELETE);
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
