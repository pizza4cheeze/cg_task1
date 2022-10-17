package ru.vsu.cs.cg.grushevskaya.graphicComponents;

import ru.vsu.cs.cg.grushevskaya.Coordinate;
import ru.vsu.cs.cg.grushevskaya.PaintTools;

import java.awt.*;

public class MelonPult {
    public Color melonColor = new Color(83, 160, 35);
    public Color stripesColor = new Color(144, 206, 91);
    public Color slinkyColor = new Color(139, 104, 20);
    public Color bucketColor = new Color(139, 104, 20);
    public Color leavesColor = new Color(67, 215, 18);
    public Color eyesColor = new Color(4, 2, 2);
    public Color browsColor = new Color(48, 106, 15);
    public Color contourColor = new Color(15, 53, 8);

    Coordinate coordinate;

    public MelonPult(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void drawMelonPult(Graphics2D g2d) {
        PaintTools.drawMelonPult(g2d, this.coordinate);

    }


}
