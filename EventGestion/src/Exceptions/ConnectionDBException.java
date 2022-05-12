package Exceptions;


import javax.swing.*;

public class ConnectionDBException extends Exception {

    public ConnectionDBException () {

    }
    public String getMessage( ) {
        return "Connection to database failed";
    }

    public void connectionDBFailed() {
        JOptionPane.showMessageDialog(null, getMessage(), "Failed Connection", JOptionPane.ERROR_MESSAGE);
        System.exit(0);
    }
}
