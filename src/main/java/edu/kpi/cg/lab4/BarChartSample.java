package edu.kpi.cg.lab4;

import edu.kpi.cg.lab3.Torus;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import org.jzy3d.maths.Coord3d;

public class BarChartSample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Coord3d[] coordinates = Torus.getCoordinates(5, 3, 50, 0, 0, 0, 2 * Math.PI);

        stage.setTitle("Bar Chart");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String, Number> bc =
                new BarChart<String, Number>(xAxis, yAxis);
        bc.setTitle("Points");
        xAxis.setLabel("X");
        yAxis.setLabel("Y");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("First fourth");

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Second fourth");
        for (Coord3d point : coordinates) {
            if (point.x > 0) {
                System.out.println("ser 1");
                series1.getData().add(new XYChart.Data(String.valueOf(point.x), point.y));
            } else {
                System.out.println("ser 2");
                series2.getData().add(new XYChart.Data(String.valueOf(point.x), point.y));
            }
        }

        Scene scene = new Scene(bc, 800, 600);
        bc.getData().addAll(series1, series2);
        stage.setScene(scene);
        stage.show();
    }
}