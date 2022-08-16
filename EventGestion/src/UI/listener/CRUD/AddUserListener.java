package UI.listener.CRUD;

import exception.*;
import model.UserModel;
import model.UserTypeModel;
import UI.panel.UserFormPanel;
import UI.panel.BusinessTaskPanel;
import UI.window.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class AddUserListener implements ActionListener {

    private UserFormPanel userFormPanel;
    private UserModel userModel;

    private MainWindow mainWindow;

    public AddUserListener(UserFormPanel userFormPanel, MainWindow mainWindow) {
        this.userFormPanel = userFormPanel;
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String message = "";
        String firstname = userFormPanel.getFirstName();
        String lastname = userFormPanel.getLastName();
        Date birthDate = userFormPanel.getBirthDate();
        Boolean isPMR = userFormPanel.getIsPMR();
        String profession = userFormPanel.getProfession();
        String nbChildrenSTR = userFormPanel.getNbChildren();
        UserTypeModel userType = userFormPanel.getUserType();

        if (firstname.trim().isEmpty()) {
            message += " - Firstname is required\n";
            userFormPanel.setBorderObject('f');
        }
        if (lastname.trim().isEmpty()) {
            message += " - Lastname is required \n";
            userFormPanel.setBorderObject('l');
        }
        if (birthDate == null) {
            message += " - Birthday date is required \n";
            userFormPanel.setBorderObject('b');
        }

        if (userType == null) {
            message += " - Combobox user type\n";
            userFormPanel.setBorderObject('u');
        }
        if(nbChildrenSTR.trim().isEmpty() || nbChildrenSTR.trim().equals("-1")){
            nbChildrenSTR="0";
        }


        if (!message.trim().isEmpty())
            JOptionPane.showMessageDialog(userFormPanel, message, "Error", JOptionPane.ERROR_MESSAGE);
        else {
            try {
                int nbChildren = Integer.parseInt(nbChildrenSTR);

                userModel = new UserModel(firstname, lastname, birthDate, isPMR, profession, nbChildren, userType.getIdusertype());
                mainWindow.getEventsManagementController().addUser(userModel);

                JOptionPane.showMessageDialog(userFormPanel, "The user has been added correctly", "Validation", JOptionPane.INFORMATION_MESSAGE);
                mainWindow.getFrameContainer().removeAll();
                mainWindow.getFrameContainer().add(new BusinessTaskPanel(mainWindow), BorderLayout.CENTER);
                mainWindow.repaint();
                mainWindow.printAll(mainWindow.getGraphics());

            } catch (AddUserException | DataAccessException | EventException ex) {
                    JOptionPane.showMessageDialog(userFormPanel, ex.getMessage(), "Error add user", JOptionPane.ERROR_MESSAGE);
            }
            catch(NumberFormatException f){
                JOptionPane.showMessageDialog(userFormPanel, f.getMessage(), "Error format nbChildren", JOptionPane.ERROR_MESSAGE);
            }
        }
        }
    }
