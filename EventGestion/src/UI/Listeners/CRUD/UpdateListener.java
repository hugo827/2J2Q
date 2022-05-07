package UI.Listeners.CRUD;

import Models.EventModel;
import UI.Panels.EventListingPanel;
import UI.Windows.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateListener implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) {
      System.out.println("Update event");
    }
}
