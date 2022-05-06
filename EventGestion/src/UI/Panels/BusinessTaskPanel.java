package UI.Panels;

import UI.Listeners.SelectUserListener;
import UI.Panels.TableModels.UserNameTableModel;
import UI.Windows.MainWindow;

import javax.swing.*;
import java.awt.*;

public class BusinessTaskPanel extends JPanel {

    private JLabel label;
    private JPanel searchEventPanel, listUserPanel, listEventPanel;

    private JButton calculateButton;
    private JTable userJTable;
    private UserNameTableModel userNameTableModel;
    private JScrollPane userJscrollpane;

    public BusinessTaskPanel() {
        this.setLayout(new BorderLayout());
        label = new JLabel("Business task panel");
        label.setHorizontalAlignment(JLabel.CENTER);
        this.add(label, BorderLayout.NORTH);
        searchEventPanel = new JPanel();
        calculateButton = new JButton("Calculate");

        listUserPanel = new JPanel();
        listEventPanel = new JPanel();

        listUserPanel.setBounds(100,100,200,550);
        listEventPanel.setBounds(400,100,500,550);
        calculateButton.setBounds(1000,350,100,25);

        userNameTableModel = new UserNameTableModel(MainWindow.getController().getUserList());
        userJTable = new JTable(userNameTableModel);
        userJscrollpane = new JScrollPane(userJTable);
        userJTable.addMouseListener(new SelectUserListener(this));
        listUserPanel.setLayout(new BorderLayout());
        listUserPanel.add(userJscrollpane, BorderLayout.CENTER);

        searchEventPanel.setLayout(null);
        searchEventPanel.add(listEventPanel);
        searchEventPanel.add(listUserPanel);
        searchEventPanel.add(calculateButton);

        calculateButton.setVisible(false);


        this.add(searchEventPanel, BorderLayout.CENTER);
    }


}
