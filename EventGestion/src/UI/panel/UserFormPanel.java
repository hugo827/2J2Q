package UI.panel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

import exception.DataAccessException;
import model.*;
import UI.listener.CRUD.*;
import UI.window.MainWindow;
import org.jdesktop.swingx.JXDatePicker;

public class UserFormPanel extends JPanel {

    private JLabel label, requiredLabel, firstNameLabel,lastNameLabel, birthDateLabel, isPMRLabel, professionLabel,nbChildrenLabel, userTypeLabel;

    private Checkbox isPMR;
    private JTextField professionTF, firstNameTF, lastNameTF, nbChildrenTF;
    private JXDatePicker birthDate;

    private JComboBox userType;

    private JButton  add , cancel;

    private JPanel form;

    private ArrayList<UserTypeModel> userTypeModelArrayList;
    private LineBorder lineBorder = new LineBorder(Color.RED, 1);

    private MainWindow mainWindow;

    private UserFormPanel(Boolean isUpdate, EventModel eventUpdate, MainWindow mainWindow) throws DataAccessException {
        this.mainWindow = mainWindow;
        this.setLayout(new BorderLayout());
        label = new JLabel( "User add panel");
        label.setHorizontalAlignment(JLabel.CENTER);

        this.add(label, BorderLayout.NORTH);
        JPanel listButton = new JPanel();
        form = new JPanel();
        form.setLayout(new GridLayout(9,2,5,5));
        listButton.setLayout(new GridLayout(1,2,5,5));


        firstNameLabel = new JLabel("*Firstname : ");
        firstNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        firstNameTF = new JTextField("");

        lastNameLabel = new JLabel("*Lastname : ");
        lastNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        lastNameTF = new JTextField("");

        isPMRLabel = new JLabel("*Is person with reduced mobility? ");
        isPMRLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        isPMR = new Checkbox(" ", false);

        birthDateLabel = new JLabel("*Birthday date: ");
        birthDateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        birthDate = new JXDatePicker();

        professionLabel = new JLabel("Profession : ");
        professionLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        professionTF = new JTextField("");

        nbChildrenLabel = new JLabel("Number of children : ");
        nbChildrenLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        nbChildrenTF = new JTextField("");

        userTypeLabel = new JLabel("*Type of user? ");
        userTypeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        userTypeModelArrayList = mainWindow.getEventsManagementController().getUserTypeList();
        userType = new JComboBox(userTypeModelArrayList.toArray());
        userType.setSelectedIndex(-1);

        requiredLabel = new JLabel("*Required field");
        requiredLabel.setForeground(Color.RED);

        cancel = new JButton("Cancel");
        add = new JButton("Add new user");

        cancel.addActionListener(new CancelUserListener(mainWindow));
        add.addActionListener(new AddUserListener(this, mainWindow));

        form.add(firstNameLabel);
        form.add(firstNameTF);
        form.add(lastNameLabel);
        form.add(lastNameTF);
        form.add(isPMRLabel);
        form.add(isPMR);
        form.add(birthDateLabel);
        form.add(birthDate);
        form.add(professionLabel);
        form.add(professionTF);
        form.add(nbChildrenLabel);
        form.add(nbChildrenTF);
        form.add(userTypeLabel);
        form.add(userType);

        form.add(requiredLabel);

        listButton.add(add);
        listButton.add(cancel);

        this.add(form, BorderLayout.CENTER);
        this.add(listButton, BorderLayout.SOUTH);

    }
    public UserFormPanel(MainWindow mainWindow) throws DataAccessException {
        this(false, null, mainWindow);
    }
    public UserFormPanel(EventModel eventUpdate, MainWindow mainWindow) throws DataAccessException {
        this(true, eventUpdate, mainWindow);
    }
    public void setBorderObject(char caract) {


        switch (caract) {
            case 'f' -> firstNameTF.setBorder(lineBorder);
            case 'l' -> lastNameTF.setBorder(lineBorder);
            case 'b' -> birthDate.setBorder(lineBorder);
            case 'u' -> userType.setBorder(lineBorder);
        }
    }


    public String getFirstName() {
        return firstNameTF.getText();
    }
    public String getLastName() {return lastNameTF.getText(); }
    public Date getBirthDate(){return birthDate.getDate(); }
    public Boolean getIsPMR(){return isPMR.getState();}
    public String getProfession(){return professionTF.getText();}
    public String getNbChildren(){return nbChildrenTF.getText().trim();}
    public UserTypeModel getUserType() {
        if(userType.getSelectedIndex() == -1) return null;
        else return userTypeModelArrayList.get(userType.getSelectedIndex());
    }

}
