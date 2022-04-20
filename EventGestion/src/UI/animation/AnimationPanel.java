package UI.animation;

import javax.swing.*;
import java.awt.*;

public class AnimationPanel extends JPanel {

    private JLabel label;
    private ScrollingDate scrollingDate;
    public AnimationPanel() {
        this.setLayout(new BorderLayout());
        label = new JLabel("Graphical Animation");
        scrollingDate  = new ScrollingDate();
        this.add(label,BorderLayout.NORTH);
        this.add(scrollingDate, BorderLayout.CENTER);
    }
}
