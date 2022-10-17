package ru.vsu.cs.cg.grushevskaya;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.util.Random;

public class PaintTools {
    private final static Color petalColor = new Color(234, 241, 240);
    private final static Color middleColor = new Color(237, 204, 61);

    public static void drawMelonPult (Graphics2D g2d, Coordinate wmCoordinate) {
        int sizeOfHeadByX = 210;
        int sizeOfHeadByY = 150;

        wmCoordinate /* watermelon - wm */ = new Coordinate(wmCoordinate.getX() - sizeOfHeadByX / 2, wmCoordinate.getY() - sizeOfHeadByY / 2);

        MelonPult melonPult = new MelonPult(wmCoordinate);

        paintWmWithStripes(g2d, wmCoordinate, melonPult, sizeOfHeadByX, sizeOfHeadByY);

        // рисование глаз и бровей
        g2d.setColor(melonPult.eyesColor);
        Coordinate leftEye = new Coordinate(wmCoordinate.getX() + sizeOfHeadByX / 2 - 20, wmCoordinate.getY() + sizeOfHeadByY / 3);
        Coordinate rightEye = new Coordinate(wmCoordinate.getX() + sizeOfHeadByX / 2 + 20, wmCoordinate.getY() + sizeOfHeadByY / 3);
        g2d.fillOval(leftEye.getX(), leftEye.getY(), 15, 25);
        g2d.fillOval(rightEye.getX(), rightEye.getY(), 15, 25);

        g2d.setColor(melonPult.browsColor);
        GeneralPath pathBrows = new GeneralPath();

        pathBrows.moveTo(leftEye.getX() - 5, leftEye.getY() - 5);
        pathBrows.curveTo(leftEye.getX() - 2, leftEye.getY() - 5, leftEye.getX() + 8, leftEye.getY() - 20, leftEye.getX() + 19, leftEye.getY() - 5);
        pathBrows.curveTo(leftEye.getX() + 19, leftEye.getY() - 5, leftEye.getX() + 8, leftEye.getY() - 10, leftEye.getX() - 2, leftEye.getY() - 5);

        pathBrows.moveTo(rightEye.getX() - 5, rightEye.getY() - 5);
        pathBrows.curveTo(rightEye.getX() - 2, rightEye.getY() - 5, rightEye.getX() + 8, rightEye.getY() - 20, rightEye.getX() + 19, rightEye.getY() - 5);
        pathBrows.curveTo(rightEye.getX() + 19, rightEye.getY() - 5, rightEye.getX() + 8, rightEye.getY() - 10, rightEye.getX() - 2, rightEye.getY() - 5);

        g2d.fill(pathBrows);

        // рисование листиков-корней
        g2d.setColor(melonPult.leavesColor);
        GeneralPath pathLeaves = new GeneralPath();
        pathLeaves.moveTo(wmCoordinate.getX() + sizeOfHeadByX / 2, wmCoordinate.getY() + sizeOfHeadByY + 5);
        pathLeaves.curveTo(wmCoordinate.getX() + sizeOfHeadByX / 2, wmCoordinate.getY() + sizeOfHeadByY - 15,
                wmCoordinate.getX() + 50, wmCoordinate.getY() + sizeOfHeadByY - 60,
                wmCoordinate.getX(), wmCoordinate.getY() + sizeOfHeadByY);
        pathLeaves.curveTo(wmCoordinate.getX(), wmCoordinate.getY() + sizeOfHeadByY,
                wmCoordinate.getX() + 20, wmCoordinate.getY() + sizeOfHeadByY - 10,
                wmCoordinate.getX() + sizeOfHeadByX / 2, wmCoordinate.getY() + sizeOfHeadByY + 5);
        pathLeaves.curveTo(wmCoordinate.getX() + sizeOfHeadByX / 2, wmCoordinate.getY() + sizeOfHeadByY + 5,
                wmCoordinate.getX() + sizeOfHeadByX - 50, wmCoordinate.getY() + sizeOfHeadByY - 60,
                wmCoordinate.getX() + sizeOfHeadByX, wmCoordinate.getY() + sizeOfHeadByY);
        pathLeaves.curveTo(wmCoordinate.getX() + sizeOfHeadByX, wmCoordinate.getY() + sizeOfHeadByY,
                wmCoordinate.getX() + sizeOfHeadByX - 10, wmCoordinate.getY() + sizeOfHeadByY - 10,
                wmCoordinate.getX() + sizeOfHeadByX / 2, wmCoordinate.getY() + sizeOfHeadByY + 5);
        g2d.fill(pathLeaves);

        // рисование пружинки, корзины и арбуза в ней
        g2d.setColor(melonPult.bucketColor);
        g2d.setStroke(new BasicStroke(15));
        GeneralPath pathSlinky = new GeneralPath();
        pathSlinky.moveTo(wmCoordinate.getX() - 8, wmCoordinate.getY() + sizeOfHeadByY / 2);
        pathSlinky.curveTo(wmCoordinate.getX() - 8, wmCoordinate.getY() + sizeOfHeadByY / 2,
                wmCoordinate.getX() - 60, wmCoordinate.getY() + sizeOfHeadByY / 2,
                wmCoordinate.getX() - 60, wmCoordinate.getY());
        Coordinate melonInBucket = new Coordinate(wmCoordinate.getX() - 60 - sizeOfHeadByX / 2, wmCoordinate.getY() - sizeOfHeadByY - 10);
        g2d.draw(pathSlinky);

        paintWmWithStripes(g2d, melonInBucket, melonPult, sizeOfHeadByX, sizeOfHeadByY);

        g2d.setColor(melonPult.bucketColor);
        GeneralPath pathBucket = new GeneralPath();
        pathBucket.moveTo(melonInBucket.getX(), melonInBucket.getY() + sizeOfHeadByY - 30);
        pathBucket.curveTo(melonInBucket.getX(), melonInBucket.getY() + sizeOfHeadByY - 30,
                melonInBucket.getX() + sizeOfHeadByX / 2, melonInBucket.getY() + sizeOfHeadByY + 60,
                melonInBucket.getX() + sizeOfHeadByX, melonInBucket.getY() + sizeOfHeadByY - 30);
        pathBucket.curveTo(melonInBucket.getX() + sizeOfHeadByX, melonInBucket.getY() + sizeOfHeadByY - 30,
                melonInBucket.getX() + sizeOfHeadByX / 2, melonInBucket.getY() + sizeOfHeadByY,
                melonInBucket.getX(), melonInBucket.getY() + sizeOfHeadByY - 30);
        pathBucket.closePath();
        g2d.fill(pathBucket);


    }

    public static void paintWmWithStripes(Graphics2D g2d, Coordinate wmCoordinate, MelonPult melonPult, int sizeOfHeadByX, int sizeOfHeadByY) {
        // рисование овала арбуза
        g2d.setColor(melonPult.melonColor);
        g2d.fillOval(wmCoordinate.getX(), wmCoordinate.getY(), sizeOfHeadByX, sizeOfHeadByY);

        // рисование полос на арбузе
        g2d.setColor(melonPult.stripesColor);
        g2d.setStroke(new BasicStroke(2));

        // верхняя
        GeneralPath pathStripe1 = new GeneralPath();
        pathStripe1.moveTo(wmCoordinate.getX(), wmCoordinate.getY() + (float) (sizeOfHeadByY / 2));
        pathStripe1.curveTo(wmCoordinate.getX(), wmCoordinate.getY() + (sizeOfHeadByY / 2), wmCoordinate.getX() + sizeOfHeadByX / 2, wmCoordinate.getY() - 30,
                wmCoordinate.getX() + sizeOfHeadByX, wmCoordinate.getY() + sizeOfHeadByY / 2);

        pathStripe1.curveTo(wmCoordinate.getX() + sizeOfHeadByX, wmCoordinate.getY() + sizeOfHeadByY / 2, wmCoordinate.getX() + sizeOfHeadByX / 2, wmCoordinate.getY(),
                wmCoordinate.getX(), wmCoordinate.getY() + (sizeOfHeadByY / 2));
        pathStripe1.closePath();
        g2d.fill(pathStripe1);

        // средняя
        GeneralPath pathStripe2 = new GeneralPath();
        pathStripe2.moveTo(wmCoordinate.getX(), wmCoordinate.getY() + (float) (sizeOfHeadByY / 2));
        pathStripe2.curveTo(wmCoordinate.getX(), wmCoordinate.getY() + (sizeOfHeadByY / 2), wmCoordinate.getX() + sizeOfHeadByX / 2, wmCoordinate.getY() + sizeOfHeadByY,
                wmCoordinate.getX() + sizeOfHeadByX, wmCoordinate.getY() + sizeOfHeadByY / 2);

        pathStripe2.curveTo(wmCoordinate.getX() + sizeOfHeadByX, wmCoordinate.getY() + sizeOfHeadByY / 2,
                wmCoordinate.getX() + sizeOfHeadByX / 2, wmCoordinate.getY() + sizeOfHeadByY / 2 + 30,
                wmCoordinate.getX(), wmCoordinate.getY() + (sizeOfHeadByY / 2));
        pathStripe2.closePath();
        g2d.fill(pathStripe2);

        // нижняя
        GeneralPath pathStripe3 = new GeneralPath();
        pathStripe3.moveTo(wmCoordinate.getX(), wmCoordinate.getY() + (float) (sizeOfHeadByY / 2));
        pathStripe3.curveTo(wmCoordinate.getX(), wmCoordinate.getY() + (sizeOfHeadByY / 2), wmCoordinate.getX() + sizeOfHeadByX / 2, wmCoordinate.getY() + sizeOfHeadByY * 1.5,
                wmCoordinate.getX() + sizeOfHeadByX, wmCoordinate.getY() + sizeOfHeadByY / 2);

        pathStripe3.curveTo(wmCoordinate.getX() + sizeOfHeadByX, wmCoordinate.getY() + sizeOfHeadByY / 2,
                wmCoordinate.getX() + sizeOfHeadByX / 2, wmCoordinate.getY() + sizeOfHeadByY + 40,
                wmCoordinate.getX(), wmCoordinate.getY() + (sizeOfHeadByY / 2));
        pathStripe3.closePath();
        g2d.fill(pathStripe3);

        // контур арбуза
        g2d.setColor(melonPult.contourColor);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawOval(wmCoordinate.getX(), wmCoordinate.getY(), sizeOfHeadByX, sizeOfHeadByY);
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
