package UI.Panels;

import javax.swing.*;
import java.awt.*;

public class HomePanel extends JPanel {

    public HomePanel() {
        this.setLayout(new BorderLayout());
        JLabel welcome = new JLabel(" Welcome to our application :) ");
        welcome.setFont(new Font("Serif", Font.BOLD, 26));
        welcome.setForeground(Color.WHITE);
        welcome.setHorizontalAlignment(JLabel.CENTER);

        ImageIcon concert = new ImageIcon("pics/concert.gif");
        JLabel background = new JLabel(concert);

        this.setBackground(Color.BLACK);
        this.add(welcome, BorderLayout.NORTH);
        this.add(background, BorderLayout.CENTER);

    }
}
