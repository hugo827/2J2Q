package UI.listener.Search;

import exception.DataAccessException;
import UI.panel.SearchPromotionPanel;
import UI.panel.TableModels.SearchPromotionTableModel;
import UI.window.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchPromotionListener  implements ActionListener {

    private SearchPromotionPanel searchPromotionPanel;
    private MainWindow mainWindow;
    public SearchPromotionListener(SearchPromotionPanel searchPromotionPanel, MainWindow mainWindow) {
        this.searchPromotionPanel = searchPromotionPanel;
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int idUserType = searchPromotionPanel.getUserTypeModelArrayList().get(searchPromotionPanel.getUserType().getSelectedIndex()).getIdusertype();
            SearchPromotionTableModel searchPromotionTableModel = new SearchPromotionTableModel(mainWindow.getEventsManagementController().getSearchByUserType(idUserType));
            searchPromotionPanel.setJTable(searchPromotionTableModel);
        } catch (DataAccessException ex) {
            JOptionPane.showMessageDialog(searchPromotionPanel, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
}
