package ru.vsu.cs.cg.grushevskaya;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DrawPanel extends JPanel {
    private final Color lightGrassColor = new Color(4, 200, 20);
    private final Color mediumGrassColor = new Color(2, 157, 14);
    private final Color darkGrassColor = new Color(2, 132, 8);

    private final Color petalColor = new Color(234, 241, 240);
    private final Color middleColor = new Color(237, 204, 61);


    @Override
    protected void paintComponent(Graphics g) {
        // размер клетки - 250 на 300
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(mediumGrassColor);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        g.setColor(lightGrassColor);
        for (int x = 50; x < this.getWidth(); x+=500) {
            g.fillRect(x, 0, 250, this.getHeight());
        }

        g.setColor(mediumGrassColor);
        for (int y = 60; y < this.getHeight(); y += 600) {
            g.fillRect(0, y, this.getWidth(), 300);
        }

        g.setColor(darkGrassColor);
        for (int y = 60; y < this.getHeight(); y += 600) {
            for (int x = -200; x < this.getWidth(); x += 500) {
                g.fillRect(x, y, 250, 300);
            }
        }

        Random random = new Random();
        int amountOfDaisies = random.nextInt(this.getWidth() / 20);

        

    }
}
