package UI.listener.Menu;

import UI.panel.SearchDatesPanel;
import UI.window.MainWindow;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchDatesListener implements ActionListener {

    private MainWindow mainWindow;
    public SearchDatesListener(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        mainWindow.setTitle("Events Management - Search Event by dates");
        mainWindow.getFrameContainer().removeAll();
        mainWindow.getFrameContainer().add(new SearchDatesPanel(), BorderLayout.CENTER);
        mainWindow.printAll(mainWindow.getGraphics());
    }
}
