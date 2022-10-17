package ru.vsu.cs.cg.grushevskaya.graphicComponents;

import ru.vsu.cs.cg.grushevskaya.Coordinate;

import java.awt.*;

public class AnimatedТext {
    Coordinate coordinate;
    String text = "Plants vs Zombies";
    Color textColor = new Color(36, 234, 76);

    final String font = "DS Sharper";
    int fontSize;

    public AnimatedТext(Coordinate coordinate, int fontSize) {
        this.coordinate = coordinate;
        this.fontSize = fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public String getText() {
        return text;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Color getTextColor() {
        return textColor;
    }

    public String getFont() {
        return font;
    }

    public int getFontSize() {
        return fontSize;
    }
}
