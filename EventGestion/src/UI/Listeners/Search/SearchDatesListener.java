package UI.Listeners.Search;

import Exceptions.SearchDateException;
import UI.Panels.SearchDatesPanel;
import UI.Panels.TableModels.SearchDatesTableModel;
import UI.Windows.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchDatesListener implements ActionListener {

    private SearchDatesPanel searchDatesPanel;


    public SearchDatesListener(SearchDatesPanel searchDatesPanel) {
        this.searchDatesPanel = searchDatesPanel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        SearchDatesTableModel searchDatesTableModel = null;
        try {
            searchDatesTableModel = new SearchDatesTableModel(MainWindow.getController().getSearchByDates(searchDatesPanel.getStartDate(), searchDatesPanel.getEndDate()));
        } catch (SearchDateException ex) {
            JOptionPane.showMessageDialog(searchDatesPanel, ex.getMessage(), "Error dates", JOptionPane.ERROR_MESSAGE);
        }
        searchDatesPanel.setTable(searchDatesTableModel);
    }
}
