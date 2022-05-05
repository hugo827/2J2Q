package UI.Listeners.Menu;

import UI.Panels.SearchDatesPanel;
import UI.Windows.MainWindow;

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
        mainWindow.getFrameContainer().removeAll();
        mainWindow.getFrameContainer().setLayout(new BorderLayout());
        mainWindow.getFrameContainer().add(new SearchDatesPanel(), BorderLayout.CENTER);
        mainWindow.repaint();
        mainWindow.printAll(mainWindow.getGraphics());
    }
}
