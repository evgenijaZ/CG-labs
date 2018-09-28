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
        Coord3d[] points = getCoordinates(5, 3, 500, 0, 2 * PI, -PI, PI);
        Scatter scatter = new Scatter(points, Color.BLUE);
        chart = AWTChartComponentFactory.chart(Quality.Advanced, "newt");
        chart.getScene().add(scatter);
    }

    Coord3d[] getCoordinates(double R, double r, int size, int phiFloor, double phiCell, double thetaFloor, double thetaCell) {
        double x;
        double y;
        double z;

        Coord3d[] points = new Coord3d[size * size];
        double phi, theta;
        int i = 0;
        for (phi = phiFloor; phi < phiCell; phi += phiCell / size) {
            for (theta = thetaFloor; theta < thetaCell; theta += abs(thetaFloor) + abs(thetaCell) / size) {
                x = (R + r * cos(phi)) * cos(theta);
                y = (R + r * cos(phi)) * sin(theta);
                z = r * sin(phi);
                points[i++] = new Coord3d(x, y, z);
            }
        }
        return points;
    }
}