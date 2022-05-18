package UI.listener.Search;

import exception.SearchDateException;
import UI.panel.SearchDatesPanel;
import UI.panel.TableModels.SearchDatesTableModel;
import UI.window.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchDatesListener implements ActionListener {

    private SearchDatesPanel searchDatesPanel;
    private MainWindow mainWindow;


    public SearchDatesListener(SearchDatesPanel searchDatesPanel, MainWindow mainWindow) {
        this.searchDatesPanel = searchDatesPanel;
        this.mainWindow = mainWindow;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        SearchDatesTableModel searchDatesTableModel = null;
        try {
            searchDatesTableModel = new SearchDatesTableModel(mainWindow.getEventsManagementController().getSearchByDates(searchDatesPanel.getStartDate(), searchDatesPanel.getEndDate()));
        } catch (SearchDateException ex) {
            JOptionPane.showMessageDialog(searchDatesPanel, ex.getMessage(), "Error dates", JOptionPane.ERROR_MESSAGE);
        }
        searchDatesPanel.setTable(searchDatesTableModel);
    }
}
