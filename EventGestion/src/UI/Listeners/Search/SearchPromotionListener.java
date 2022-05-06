package UI.Listeners.Search;

import UI.Panels.SearchPromotionPanel;
import UI.Panels.TableModels.SearchPromotionTableModel;
import UI.Windows.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchPromotionListener  implements ActionListener {

    private SearchPromotionPanel searchPromotionPanel;

    public SearchPromotionListener(SearchPromotionPanel searchPromotionPanel) {
        this.searchPromotionPanel = searchPromotionPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int idUserType = searchPromotionPanel.getUserTypeModelArrayList().get(searchPromotionPanel.getUserType().getSelectedIndex()).getIdusertype();
        SearchPromotionTableModel searchPromotionTableModel = new SearchPromotionTableModel(MainWindow.getController().getSearchByUserType(idUserType));
        searchPromotionPanel.setJTable(searchPromotionTableModel);
    }
}
