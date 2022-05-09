package UI.Listeners.Search;

import UI.Panels.SearchDatesPanel;
import UI.Panels.TableModels.SearchDatesTableModel;
import UI.Windows.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchDatesListener implements ActionListener {

    private SearchDatesPanel searchDatesPanel;


    public SearchDatesListener(SearchDatesPanel searchDatesPanel) {
        this.searchDatesPanel = searchDatesPanel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        SearchDatesTableModel searchDatesTableModel = new SearchDatesTableModel(MainWindow.getController().getSearchByDates(searchDatesPanel.getStartDate(), searchDatesPanel.getEndDate()));
        searchDatesPanel.setTable(searchDatesTableModel);
    }
}
