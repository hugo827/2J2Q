package UI.Listeners.Menu;


import UI.Panels.EventAddPanel;
import UI.Windows.MainWindow;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventCreateListener implements ActionListener {

    private MainWindow mainWindow;

    public EventCreateListener(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        mainWindow.setTitle("Event Gestion - Add new event");
        mainWindow.getFrameContainer().removeAll();
        mainWindow.getFrameContainer().setLayout(new BorderLayout());
        mainWindow.getFrameContainer().add(new EventAddPanel(), BorderLayout.CENTER);
        mainWindow.repaint();
        mainWindow.printAll(mainWindow.getGraphics());
    }

}
