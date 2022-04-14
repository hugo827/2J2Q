package UI.Windows;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private Container frameContainer;
    public MainWindow() {
        super("Gestion d'événement");

        setBounds(10,10,1300,800);

        frameContainer = this.getContentPane();
        setVisible(true);
    }

    public Container getFrameContainer() {
        return frameContainer;
    }
}
