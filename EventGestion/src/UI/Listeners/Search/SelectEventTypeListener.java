package UI.Listeners.Search;

import UI.Panels.SearchEventTypePanel;
import UI.Panels.TableModels.SearchEventTypeTableModel;
import UI.Windows.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectEventTypeListener implements ActionListener {


    private SearchEventTypePanel searchEventTypePanel;
    public SelectEventTypeListener(SearchEventTypePanel searchEventTypePanel) {
        this.searchEventTypePanel = searchEventTypePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int idEventType = searchEventTypePanel.getEventTypeModelArrayList().get(searchEventTypePanel.getEventTypes().getSelectedIndex()).getIdEventType();
        SearchEventTypeTableModel searchEventTypeTableModel = new SearchEventTypeTableModel(MainWindow.getController().getSearchByEventType(idEventType));
        searchEventTypePanel.setJTable(searchEventTypeTableModel);
    }
}
