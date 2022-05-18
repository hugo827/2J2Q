package UI.listener.Search;

import exception.DataAccessException;
import UI.panel.SearchEventTypePanel;
import UI.panel.TableModels.SearchEventTypeTableModel;
import UI.window.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectEventTypeListener implements ActionListener {


    private SearchEventTypePanel searchEventTypePanel;
    private MainWindow mainWindow;
    public SelectEventTypeListener(SearchEventTypePanel searchEventTypePanel, MainWindow mainWindow) {
        this.searchEventTypePanel = searchEventTypePanel;
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int idEventType = searchEventTypePanel.getEventTypeModelArrayList().get(searchEventTypePanel.getEventTypes().getSelectedIndex()).getIdEventType();
            SearchEventTypeTableModel  searchEventTypeTableModel = new SearchEventTypeTableModel(mainWindow.getEventsManagementController().getSearchByEventType(idEventType));
            searchEventTypePanel.setJTable(searchEventTypeTableModel);
        } catch (DataAccessException ex) {
            JOptionPane.showMessageDialog(searchEventTypePanel, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
}
