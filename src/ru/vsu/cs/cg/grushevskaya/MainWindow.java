package ru.vsu.cs.cg.grushevskaya;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private DrawPanel dp;

    public MainWindow() {
        Dimension windowSize = new Dimension(1024, 768);
        setSize(windowSize);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize ();
        setLocation((screenSize.width - windowSize.width) / 2, (screenSize.height - windowSize.height) / 2);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        dp = new DrawPanel();
        this.add(dp);
    }
}
