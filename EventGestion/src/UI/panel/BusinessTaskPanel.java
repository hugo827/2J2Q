package UI.panel;

import exception.DataAccessException;
import model.UserModel;
import UI.listener.Search.CalculateListener;
import UI.listener.Business.SelectEventListener;
import UI.listener.Business.SelectUserListener;
import UI.panel.TableModels.EventTableModel;
import UI.panel.TableModels.UserNameTableModel;
import UI.window.MainWindow;

import javax.swing.*;
import java.awt.*;

public class BusinessTaskPanel extends JPanel {

    private JLabel label;
    private JPanel searchEventPanel, listUserPanel, listEventPanel;

    private JButton calculateButton;
    private JTable userJTable, eventJTable;
    private UserNameTableModel userNameTableModel;
    private EventTableModel eventTableModel;
    private JScrollPane userJscrollpane, eventJScrollpane;

    private MainWindow mainWindow;
    public BusinessTaskPanel(MainWindow mainWindow) throws DataAccessException {
        this.mainWindow = mainWindow;
        this.setLayout(new BorderLayout());
        label = new JLabel("Business task panel");
        label.setHorizontalAlignment(JLabel.CENTER);
        this.add(label, BorderLayout.NORTH);
        searchEventPanel = new JPanel();
        calculateButton = new JButton("Calculate");

        listUserPanel = new JPanel();
        listEventPanel = new JPanel();

        listUserPanel.setBounds(0,50,150,550);
        listEventPanel.setBounds(200,50,900,550);
        calculateButton.setBounds(600,625,100,25);

        userNameTableModel = new UserNameTableModel(mainWindow.getEventsManagementController().getUserList());
        userJTable = new JTable(userNameTableModel);
        userJTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        userJTable.getTableHeader().setReorderingAllowed(false);
        userJscrollpane = new JScrollPane(userJTable);
        userJTable.addMouseListener(new SelectUserListener(this));
        listUserPanel.setLayout(new BorderLayout());
        listUserPanel.add(userJscrollpane, BorderLayout.CENTER);


        eventJTable = new JTable(eventTableModel);
        eventJScrollpane = new JScrollPane(eventJTable);
        listEventPanel.setLayout(new BorderLayout());
        listEventPanel.add(eventJScrollpane, BorderLayout.CENTER);

        searchEventPanel.setLayout(null);
        searchEventPanel.add(listEventPanel);
        searchEventPanel.add(listUserPanel);
        searchEventPanel.add(calculateButton);


        listEventPanel.setVisible(false);
        calculateButton.addActionListener(new CalculateListener(this));
        calculateButton.setVisible(false);

        this.add(searchEventPanel, BorderLayout.CENTER);
    }


    public void setNewEventPanel() throws DataAccessException {
        int line = userJTable.getSelectedRow();
        UserModel selectUser = (UserModel) userJTable.getValueAt(line, 0);
        eventTableModel = new EventTableModel(mainWindow.getEventsManagementController().getUserEventList(selectUser.getIduser()));
        eventJTable = new JTable(eventTableModel);
        eventJTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        eventJTable.getTableHeader().setReorderingAllowed(false);
        eventJTable.addMouseListener(new SelectEventListener(this));
        eventJScrollpane.setViewportView(eventJTable);
        listEventPanel.setVisible(true);
        calculateButton.setVisible(false);
    }

    public void viewButton() {
        calculateButton.setVisible(true);
    }

    public void showInformation() throws DataAccessException {
        String msg = mainWindow.getEventsManagementController().getInformationEvent((Integer) eventJTable.getValueAt(eventJTable.getSelectedRow(), 0));
        JOptionPane.showMessageDialog(this, msg, "Information Event", JOptionPane.PLAIN_MESSAGE);
    }
}
