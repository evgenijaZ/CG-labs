package edu.kpi.cg.lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Drawer extends JPanel implements ActionListener {
    private boolean initialize = true;
    private double size;
    private int step = 1;
    private BaseShape baseShape;

    public Drawer(int delay, BaseShape baseShape) {
        this.baseShape = baseShape;
        Timer timer = new Timer(delay, this);
        timer.start();
    }

    private void paintBasicShape(Graphics graphics, int x, int y, int width) {
        baseShape.setX(x);
        baseShape.setY(y);
        baseShape.setWidth(width);
        baseShape.paint(graphics);
    }

    private void paintOrnament(Graphics graphics, int count, int radius, int width) {

        for (int i = 0; i < count; i++) {
            double x;
            double y;
            double fi = (2 * 3.14 / count) * i;

            x = Math.cos(fi) * radius;
            y = Math.sin(fi) * radius;
            paintBasicShape(graphics, (int) x + radius + width + 80, (int) y + radius + width + 80, width);
        }
    }


    private void paintWithEffects(Graphics graphics, int radius) {
        paintOrnament(graphics, radius * radius / 500, radius, radius * radius / 500);
    }

    public void paint(Graphics graphics) {
        super.paintComponent(graphics);

        double maxSize = 300;
        if (initialize) {
            size = maxSize * Math.random();
            initialize = false;
        }

        size += step;
        if (size > maxSize || size < 10) {
            step *= -1;
        }

        baseShape.setColor(Color.RED);

      paintWithEffects(graphics, (int) size);
      // paintOrnament(graphics, 10, 200, 40 );
      //  paintBasicShape(graphics, 320, 320, 100);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
