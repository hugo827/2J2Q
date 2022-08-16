package UI.listener.CRUD;
import UI.listener.Menu.UserCreateListener;
import UI.window.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancelUserListener implements ActionListener{
    private MainWindow mainWindow;

    public CancelUserListener(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        UserCreateListener userCreateListener = new UserCreateListener(mainWindow);
        userCreateListener.actionPerformed(e);
    }
}
