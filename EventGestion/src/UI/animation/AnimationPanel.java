package UI.animation;

import javax.swing.*;
import java.awt.*;

public class AnimationPanel extends JPanel {

    private ScrollingDate scrollingDate;
    public AnimationPanel() {
        this.setLayout(new BorderLayout());
        scrollingDate  = new ScrollingDate();
        this.add(scrollingDate, BorderLayout.CENTER);
    }
}
