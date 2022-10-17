package ru.vsu.cs.cg.grushevskaya.graphicComponents;

import ru.vsu.cs.cg.grushevskaya.PaintTools;

import java.awt.*;

public class Lawn {
    int width;
    int height;

    public Lawn(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void drawTheLawn(Graphics2D g2d) {
        PaintTools.drawTheLawn(g2d, this.width, this.height);
    }
}
