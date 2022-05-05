package UI.Listeners.CRUD;

import UI.Panels.EventListingPanel;
import UI.Windows.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class deleteListener implements ActionListener {

    private EventListingPanel eventListingPanel;

    public deleteListener(EventListingPanel eventListingPanel) {
        this.eventListingPanel = eventListingPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JTable jTable = eventListingPanel.getEventsTable();
        int idEvent = (int)jTable.getValueAt(jTable.getSelectedRow(),0);

        System.out.println(idEvent);

//        try {
//       MainWindow.getController().deleteEvent();
//        } catch (DeleteDetailLineException deleteDetailLineException) {
//            JOptionPane.showMessageDialog(null, "An error has occurred while deleting detail lines", "Error", JOptionPane.ERROR_MESSAGE);
//        }
        MainWindow.getMainWindow().repaint();
        MainWindow.getMainWindow().printAll(MainWindow.getMainWindow().getGraphics());
    }
}
