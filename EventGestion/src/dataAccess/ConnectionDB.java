package dataAccess;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    private static Connection connection;

    private ConnectionDB() {
        try{
            connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/eventmanagmentdb", "WWHJ", "wWhJ5000+");
        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(null,   "Database connection failed.\n Call admin or retry later.", "Error connection", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static Connection getInstance() throws SQLException {
        if(connection == null) {
            new ConnectionDB();
        }

        return connection;
    }

}
