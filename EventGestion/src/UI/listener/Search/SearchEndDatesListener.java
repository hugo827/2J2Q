package UI.listener.Search;

import exception.DataAccessException;
import UI.panel.SearchEndDatesPanel;
import UI.panel.TableModels.SearchEndDatesTableModel;
import UI.window.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchEndDatesListener implements ActionListener {

    private SearchEndDatesPanel searchEndDatesPanel;
    private MainWindow mainWindow;


    public SearchEndDatesListener(SearchEndDatesPanel searchEndDatesPanel, MainWindow mainWindow) {
        this.searchEndDatesPanel = searchEndDatesPanel;
        this.mainWindow = mainWindow;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        SearchEndDatesTableModel searchEndDatesTableModel = null;
        try {
            searchEndDatesTableModel = new SearchEndDatesTableModel(mainWindow.getEventsManagementController().getSearchByEndDates( searchEndDatesPanel.getEndDate()));
        } catch ( DataAccessException ex) {
            JOptionPane.showMessageDialog(searchEndDatesPanel, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        searchEndDatesPanel.setTable(searchEndDatesTableModel);
    }
}
