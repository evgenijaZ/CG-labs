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
        Coord3d[] points = getCoordinates(5, 3, 500, 0, 0, -PI, PI);
        Scatter scatter = new Scatter(points, Color.BLUE);
        chart = AWTChartComponentFactory.chart(Quality.Advanced, "newt");
        chart.getScene().add(scatter);
    }

    public static Coord3d[] getCoordinates(double R, double r, int size, int phiFloor, double phiCell, double thetaFloor, double thetaCell) {
        double x;
        double y;
        double z;

        Coord3d[] points = new Coord3d[size * size];
        double phi = phiFloor, theta = thetaFloor;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                x = (R + r * cos(phi)) * cos(theta);
                y = (R + r * cos(phi)) * sin(theta);
                z = r * sin(phi);
                points[size*i+j] = new Coord3d(x, y, z);
                theta += (abs(thetaFloor) + abs(thetaCell)) / size;
            }
            phi += (abs(phiFloor) + abs(phiCell)) / size;
        }
        return points;
    }
}