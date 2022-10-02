package ru.vsu.cs.cg.grushevskaya;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DrawPanel extends JPanel {
    private final Color lightGrassColor = new Color(4, 200, 20);
    private final Color mediumGrassColor = new Color(2, 157, 14);
    private final Color darkGrassColor = new Color(2, 132, 8);

    @Override
    protected void paintComponent(Graphics g) {
        // размер клетки - 250 на 300
        // начало рисования клеток - (50, 60)

        Graphics2D g2d = (Graphics2D) g;

        int startCellsByX = 50;
        int startCellsByY = 60;

        final int sizeOfCellsByX = 250;
        final int sizeOfCellsByY = 300;

        g2d.setColor(mediumGrassColor);
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());

        g2d.setColor(lightGrassColor);
        for (int x = startCellsByX; x < this.getWidth(); x += sizeOfCellsByX * 2) {
            g2d.fillRect(x, 0, sizeOfCellsByX, this.getHeight());
        }

        g2d.setColor(mediumGrassColor);
        for (int y = startCellsByY; y < this.getHeight(); y += sizeOfCellsByY * 2) {
            g2d.fillRect(0, y, this.getWidth(), sizeOfCellsByY);
        }

        g2d.setColor(darkGrassColor);
        for (int y = startCellsByY; y < this.getHeight(); y += sizeOfCellsByY * 2) {
            for (int x = startCellsByX - sizeOfCellsByX; x < this.getWidth(); x += sizeOfCellsByX * 2) {
                g2d.fillRect(x, y, sizeOfCellsByX, sizeOfCellsByY);
            }
        }

        //PaintTools.makeCellBorders(g2d, 50, 60, this.getWidth(), this.getHeight());
        PaintTools.createDaisies(g2d, this.getWidth(), this.getHeight());
        //PaintTools.drawMelonPult(g2d, new Coordinate(startCellsByX + sizeOfCellsByX * 3 / 2, startCellsByY + sizeOfCellsByY * 3 / 2));
        PaintTools.drawMelonPult(g2d, new Coordinate(425, 240));

    }
}
