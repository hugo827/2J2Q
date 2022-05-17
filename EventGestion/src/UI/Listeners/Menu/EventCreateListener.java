package UI.Listeners.Menu;


import UI.Panels.EventFormPanel;
import UI.Windows.MainWindow;
import com.sun.tools.javac.Main;


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
        MainWindow.refreshPanel(new EventFormPanel(), "Add new event");
//        mainWindow.setTitle("Events Management - Add new event");
//        mainWindow.getFrameContainer().removeAll();
//        mainWindow.getFrameContainer().setLayout(new BorderLayout());
//        mainWindow.getFrameContainer().add(new EventFormPanel(), BorderLayout.CENTER);
//        mainWindow.repaint();
//        mainWindow.printAll(mainWindow.getGraphics());
    }

}
