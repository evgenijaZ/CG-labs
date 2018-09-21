package edu.kpi.cg.lab2;
import edu.kpi.cg.lab1.BaseShape;

import java.awt.*;

public class PolarRose extends BaseShape {
    private double k = 1.667;

    public PolarRose() {
        this.width = 100;
    }

    private double f(double x) {
        return width * Math.cos(x) * Math.sin(k * x);
    }

    private double g(double x) {
        return width * Math.sin(x) * Math.sin(k * x);
    }

    @Override
    public void paint(Graphics graphics) {
        Polygon p = new Polygon();

        for (double i = 0; i <= 3 * Math.PI; i = i + 0.01) {
            p.addPoint((int) (f(i) + x), (int) (g(i) + y));
        }

        graphics.setColor(this.color);
        graphics.drawPolyline(p.xpoints, p.ypoints, p.npoints);

    }
}
