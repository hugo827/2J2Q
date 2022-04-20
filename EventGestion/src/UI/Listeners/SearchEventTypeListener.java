package UI.Listeners;

import UI.Panels.SearchEventTypePanel;
import UI.Windows.MainWindow;
import UI.animation.AnimationPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchEventTypeListener implements ActionListener {

    private MainWindow mainWindow;

    public SearchEventTypeListener(MainWindow mainWindow) {
        this.mainWindow = mainWindow;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainWindow.getFrameContainer().removeAll();
        mainWindow.getFrameContainer().setLayout(new BorderLayout());
        mainWindow.getFrameContainer().add(new SearchEventTypePanel(), BorderLayout.CENTER);
        mainWindow.repaint();
        mainWindow.printAll(mainWindow.getGraphics());
    }
}
