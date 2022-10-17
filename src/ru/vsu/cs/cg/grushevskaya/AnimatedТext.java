package ru.vsu.cs.cg.grushevskaya;

import java.awt.*;

public class AnimatedТext {
    Coordinate textCenter;
    String text = "Plants vs Zombies";
    Color textColor = new Color(36, 234, 76);

    final String font = "DS Sharper";
    int fontSize;

    public AnimatedТext(Coordinate textCenter, int fontSize) {
        this.textCenter = textCenter;
        this.fontSize = fontSize;
    }
}
