package UI.Panels;


import Models.SearchPromotionModel;
import Models.UserTypeModel;
import UI.Listeners.Search.SearchPromotionListener;
import UI.Panels.TableModels.SearchPromotionTableModel;
import UI.Windows.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SearchPromotionPanel extends JPanel {

    private JLabel label, promotionLabel;

    private JPanel searchPanel, promotionPanel;
    private JComboBox userType;

    private SearchPromotionTableModel searchPromotionTableModel;

    private ArrayList<SearchPromotionModel> searchPromotionModelArrayList;
    private ArrayList<UserTypeModel> userTypeModelArrayList;

    private JTable jTable;
    private JScrollPane jScrollPane;
    public SearchPromotionPanel() {
        this.setLayout(new BorderLayout());
        label = new JLabel("Search promotion panel");
        label.setHorizontalAlignment(JLabel.CENTER);
        this.add(label, BorderLayout.NORTH);

        searchPanel = new JPanel();
        promotionPanel = new JPanel();
        searchPanel.setLayout(new BorderLayout());
        promotionPanel.setLayout(new GridLayout(1,2,5,5));
        promotionLabel = new JLabel("Select user types : ");
        promotionPanel.add(promotionLabel);

        userTypeModelArrayList = MainWindow.getController().getUserTypeList();
        userType = new JComboBox(userTypeModelArrayList.toArray());
        userType.addActionListener(new SearchPromotionListener(this));
        promotionPanel.add(userType);
        searchPanel.add(promotionPanel, BorderLayout.NORTH);


        jTable = new JTable(searchPromotionTableModel);
        jScrollPane = new JScrollPane(jTable);
        searchPanel.add(jScrollPane, BorderLayout.CENTER);

        this.add(searchPanel, BorderLayout.CENTER);
    }

    public ArrayList<UserTypeModel> getUserTypeModelArrayList() { return userTypeModelArrayList; }
    public JComboBox getUserType() { return userType; }
    public void setJTable(SearchPromotionTableModel searchPromotionTableModel) {
        jTable = new JTable(searchPromotionTableModel);
        jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane.setViewportView(jTable);
    }
}
