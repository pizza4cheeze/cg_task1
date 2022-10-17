package ru.vsu.cs.cg.grushevskaya;

import ru.vsu.cs.cg.grushevskaya.graphicComponents.AnimatedТext;
import ru.vsu.cs.cg.grushevskaya.graphicComponents.Daisy;
import ru.vsu.cs.cg.grushevskaya.graphicComponents.Lawn;
import ru.vsu.cs.cg.grushevskaya.graphicComponents.MelonPult;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class DrawPanel extends JPanel {
    private ArrayList<Daisy> daisies = PaintTools.createDaisies(40);
    private AnimatedТext pvz;
    private Timer t;

    public DrawPanel() {

        pvz = new AnimatedТext(new Coordinate(this.getWidth() / 2, 100), 10); // почему то задается ширина width / 2, а появляется текст слева
        t = new Timer(100, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pvz.getFontSize() == 70) {
                    pvz.setFontSize(10);
                } else if (pvz.getFontSize() >= 10 && pvz.getFontSize() < 70) {
                    pvz.setFontSize(pvz.getFontSize() + 1);
                }
                repaint();
            }
        });
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (t.isRunning()) {
                    t.stop();
                } else {
                    t.start();
                }
            }
        });
    }


    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        Lawn lawn = new Lawn(this.getWidth(), this.getHeight());
        lawn.drawTheLawn(g2d);

        for (int i = 0; i < daisies.size(); i++) {
            Coordinate daisyCoordinate = daisies.get(i).coordinate;
            PaintTools.drawDaisy(g2d, daisyCoordinate);
        }

        MelonPult melonPult = new MelonPult(new Coordinate(425, 540));
        melonPult.drawMelonPult(g2d);

        g2d.setColor(pvz.getTextColor());
        g2d.setFont(new Font("DS Sharper", Font.PLAIN, pvz.getFontSize()));
        g2d.drawString(pvz.getText(), pvz.getCoordinate().getX(), pvz.getCoordinate().getY()); // как рассчитать чтобы текст всегда появлялся в середине?

    }
}
