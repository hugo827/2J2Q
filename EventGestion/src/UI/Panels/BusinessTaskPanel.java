package UI.Panels;

import Models.EventModel;
import Models.UserModel;
import UI.Listeners.CRUD.CancelListener;
import UI.Listeners.Search.CalculateListener;
import UI.Listeners.Search.SelectEventListener;
import UI.Listeners.Search.SelectUserListener;
import UI.Panels.TableModels.EventTableModel;
import UI.Panels.TableModels.UserNameTableModel;
import UI.Windows.MainWindow;

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


    public BusinessTaskPanel() {
        this.setLayout(new BorderLayout());
        label = new JLabel("Business task panel");
        label.setHorizontalAlignment(JLabel.CENTER);
        this.add(label, BorderLayout.NORTH);
        searchEventPanel = new JPanel();
        calculateButton = new JButton("Calculate");

        listUserPanel = new JPanel();
        listEventPanel = new JPanel();

        listUserPanel.setBounds(50,50,150,550);
        listEventPanel.setBounds(250,50,700,550);
        calculateButton.setBounds(1000,350,100,25);

        userNameTableModel = new UserNameTableModel(MainWindow.getController().getUserList());
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


    public void setNewEventPanel() {
        int line = userJTable.getSelectedRow();

        eventTableModel = new EventTableModel(MainWindow.getController().getUserEventList((Integer) userJTable.getValueAt(line, 1)));
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

    public void showInformation() {
        EventModel event = MainWindow.getController().getEvent((Integer) eventJTable.getValueAt(eventJTable.getSelectedRow(), 0));

        JOptionPane jOptionPane = new JOptionPane();
        String msg = event.getTitle();


        jOptionPane.showMessageDialog(this, msg, "Information Event", JOptionPane.PLAIN_MESSAGE);
    }
}
