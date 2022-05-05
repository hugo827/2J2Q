package UI.Listeners.Menu;

import UI.Panels.SearchPromotionPanel;
import UI.Windows.MainWindow;
import UI.animation.AnimationPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchPromotionListener implements ActionListener {

    private MainWindow mainWindow;

    public SearchPromotionListener(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        mainWindow.setTitle("Event Gestion - Search promotions");
        mainWindow.getFrameContainer().removeAll();
        mainWindow.getFrameContainer().setLayout(new BorderLayout());
        mainWindow.getFrameContainer().add(new SearchPromotionPanel(), BorderLayout.CENTER);
        mainWindow.repaint();
        mainWindow.printAll(mainWindow.getGraphics());
    }
}
