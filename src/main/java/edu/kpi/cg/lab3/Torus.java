package edu.kpi.cg.lab3;

import org.jzy3d.analysis.AbstractAnalysis;
import org.jzy3d.analysis.AnalysisLauncher;
import org.jzy3d.chart.factories.AWTChartComponentFactory;
import org.jzy3d.colors.Color;
import org.jzy3d.maths.Coord3d;
import org.jzy3d.plot3d.primitives.Scatter;
import org.jzy3d.plot3d.rendering.canvas.Quality;

import static java.lang.Math.*;


public class Torus extends AbstractAnalysis {

    public static void main(String[] args) throws Exception {
        AnalysisLauncher.open(new Torus());
    }

    @Override
    public void init() {
        final int size = 500;
        double x;
        double y;
        double z;

        Coord3d[] points = new Coord3d[size * size];
        Color[] colors = new Color[size * size];

        double R = 5, r = 3;
        double phi, theta;
        int i = 0;
        for (phi = 0; phi < 2 * PI; phi += 2 * PI / size) {
            for (theta = -PI; theta < PI; theta += 2 * PI / size) {
                x = (R + r * cos(phi)) * cos(theta);
                y = (R + r * cos(phi)) * sin(theta);
                z = r * sin(phi);
                points[i] = new Coord3d(x, y, z);
                colors[i] = new Color((float) (1 - (phi / 2 * PI)), 0, 1, 0.15f);
                i++;
            }
        }
        Scatter scatter = new Scatter(points, colors);
        chart = AWTChartComponentFactory.chart(Quality.Advanced, "newt");
        chart.getScene().add(scatter);
    }
}