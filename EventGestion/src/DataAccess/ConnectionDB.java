package DataAccess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    private static Connection connection;

    private ConnectionDB() {
        try{
            connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/eventmanagmentdb", "WWHJ", "wWhJ5000+");
        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(null,   "Connection to database failed. Click ok, to close program \n Call admin or Retry later.", "Error connection", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static Connection getInstance() {
        if(connection == null) {
            new ConnectionDB();
        }
        return connection;
    }

}
