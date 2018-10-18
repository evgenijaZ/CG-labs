package edu.kpi.cg.lab4;

import edu.kpi.cg.lab3.Torus;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import org.jzy3d.maths.Coord3d;


public class LineChartSample extends Application {

    @Override
    public void start(Stage stage) {
        Coord3d[] coordinates = Torus.getCoordinates(5, 3, 50, 0, 0, 0, 2 * Math.PI);

        stage.setTitle("Line Chart");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Points");

        final LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);

        lineChart.setTitle("Point Monitoring");

        XYChart.Series series = new XYChart.Series();
        for (Coord3d point : coordinates) {
            series.getData().add(new XYChart.Data(String.valueOf(point.x), point.y));
        }

        Scene scene = new Scene(lineChart, 800, 600);
        lineChart.getData().add(series);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}