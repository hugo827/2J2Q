package UI.Listeners.CRUD;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class VerificationNbParticipantsListener implements KeyListener {

    private JTextField jTextField;

    public VerificationNbParticipantsListener(JTextField jTextField) {
        this.jTextField = jTextField;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if( (e.getKeyChar() >= '0'  && e.getKeyChar() <= '9') || e.getKeyChar() == KeyEvent.VK_BACK_SPACE || e.getKeyChar() == KeyEvent.VK_DELETE) {
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
