package UI.panel;

import javax.swing.*;
import java.awt.*;

public class HomePanel extends JPanel {

    public HomePanel() {
        this.setLayout(new BorderLayout());
        JLabel welcome = new JLabel(" Welcome to our application :) ");
        welcome.setFont(new Font("Serif", Font.BOLD, 26));
        welcome.setHorizontalAlignment(JLabel.CENTER);
        this.add(welcome, BorderLayout.CENTER);
    }
}
