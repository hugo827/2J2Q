package UI.listener.Menu;

import UI.panel.SearchDatesPanel;
import UI.window.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchDatesListener implements ActionListener {

    private MainWindow mainWindow;
    public SearchDatesListener(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MainWindow.refreshPanel(new SearchDatesPanel(), "Search Event by dates");
//        mainWindow.setTitle("Events Management - Search Event by dates");
//        mainWindow.getFrameContainer().removeAll();
//        mainWindow.getFrameContainer().setLayout(new BorderLayout());
//        mainWindow.getFrameContainer().add(new SearchDatesPanel(), BorderLayout.CENTER);
//        mainWindow.repaint();
//        mainWindow.printAll(mainWindow.getGraphics());
    }
}
