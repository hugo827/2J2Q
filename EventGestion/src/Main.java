import DataAccess.ConnectionDB;
import UI.Windows.MainWindow;

import javax.swing.*;
import java.sql.Connection;


public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = ConnectionDB.getInstance();
            new MainWindow();
        } catch (Exception exception) {
            int i = JOptionPane.showConfirmDialog(null,   "Connection to database failed\n Do you want retry ? ", "Error connection", JOptionPane.YES_NO_OPTION);
            if(i == 0) main(new String[]{"test"});
            else System.exit(0);
        }

    }
}
