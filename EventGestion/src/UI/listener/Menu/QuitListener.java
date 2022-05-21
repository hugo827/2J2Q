package UI.listener.Menu;


import UI.window.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class QuitListener implements ActionListener {

    private MainWindow mainWindow;

    public  QuitListener(MainWindow mainWindow){this.mainWindow=mainWindow;}


    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
