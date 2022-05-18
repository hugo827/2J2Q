package UI.listener.Menu;

import UI.panel.SearchPromotionPanel;
import UI.window.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchPromotionListener implements ActionListener {

    private MainWindow mainWindow;

    public SearchPromotionListener(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MainWindow.refreshPanel(new SearchPromotionPanel(), "Search promotions");
//        mainWindow.setTitle("Events Management - Search promotions");
//        mainWindow.getFrameContainer().removeAll();
//        mainWindow.getFrameContainer().setLayout(new BorderLayout());
//        mainWindow.getFrameContainer().add(new SearchPromotionPanel(), BorderLayout.CENTER);
//        mainWindow.repaint();
//        mainWindow.printAll(mainWindow.getGraphics());
    }
}
