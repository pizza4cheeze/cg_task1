package ru.vsu.cs.cg.grushevskaya.graphicComponents;

import ru.vsu.cs.cg.grushevskaya.Coordinate;
import ru.vsu.cs.cg.grushevskaya.PaintTools;

import java.awt.*;

public class Daisy {
    public Coordinate coordinate;

    public Daisy(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void drawDaisy(Graphics2D g2d) {
        PaintTools.drawDaisy(g2d, this.coordinate);
    }
}
