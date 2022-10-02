package ru.vsu.cs.cg.grushevskaya;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.util.Random;

public class PaintTools {
    private final static Color petalColor = new Color(234, 241, 240);
    private final static Color middleColor = new Color(237, 204, 61);

    public static void drawMelonPult (Graphics2D g2d, Coordinate coordinate) {
        int sizeOfHeadByX = 210;
        int sizeOfHeadByY = 150;

        coordinate = new Coordinate(coordinate.getX() - sizeOfHeadByX / 2, coordinate.getY() - sizeOfHeadByY / 2);

        MelonPult melonPult = new MelonPult(coordinate);

        g2d.setColor(melonPult.melonColor);
        g2d.fillOval(coordinate.getX(), coordinate.getY(), sizeOfHeadByX, sizeOfHeadByY);

        g2d.setColor(melonPult.stripesColor);
        g2d.setStroke(new BasicStroke(15));
        GeneralPath path = new GeneralPath();
        // как рисовать арку и кривую????

        g2d.setColor(melonPult.contourColor);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawOval(coordinate.getX(), coordinate.getY(), sizeOfHeadByX, sizeOfHeadByY);

    }

    public static void makeCellBorders(Graphics2D g2d, int cellStartByX, int cellStartByY, int sizeByX, int sizeByY) {
        g2d.setColor(Color.black);

        g2d.setStroke(new BasicStroke(4));
        for (int i = cellStartByY; i < sizeByY; i += 300) {
            g2d.drawLine(0, i, sizeByX, i);
        }

        for (int i = cellStartByX; i < sizeByX; i += 250) {
            g2d.drawLine(i, 0, i, sizeByY);
        }
    }

    public static void createDaisies(Graphics2D g2d, int sizeByX, int sizeByY) {
        int amountOfDaisies = sizeByX / 40;

        Random random = new Random();
        for (int i = 0; i < amountOfDaisies; i++) {
            int x = random.nextInt(sizeByX);
            int y = random.nextInt(sizeByY);
            Coordinate coordinateOfDaisy = new Coordinate(x, y);
            drawDaisy(g2d, coordinateOfDaisy);
        }
    }

    private static void drawDaisy(Graphics2D g2d, Coordinate coordinateOfDaisy) {
        g2d.setColor(petalColor);
        g2d.fillOval(coordinateOfDaisy.getX() + 13, coordinateOfDaisy.getY(), 16, 12);
        g2d.fillOval(coordinateOfDaisy.getX() - 12, coordinateOfDaisy.getY(), 16, 12);
        g2d.fillOval(coordinateOfDaisy.getX() - 6, coordinateOfDaisy.getY() + 4, 17, 12);
        g2d.fillOval(coordinateOfDaisy.getX() + 6, coordinateOfDaisy.getY() + 4, 17, 12);
        g2d.fillOval(coordinateOfDaisy.getX() - 6, coordinateOfDaisy.getY() - 4, 17, 12);
        g2d.fillOval(coordinateOfDaisy.getX() + 6, coordinateOfDaisy.getY() - 4, 17, 12);

        g2d.setColor(middleColor);
        g2d.fillOval(coordinateOfDaisy.getX() - 1, coordinateOfDaisy.getY() + 1, 20, 10);
    }
}
