package edu.kpi.cg.lab4;

import edu.kpi.cg.lab3.Torus;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;
import org.jzy3d.maths.Coord3d;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class PieChartSample extends Application {

    @Override
    public void start(Stage stage) {
        Coord3d[] coordinates = Torus.getCoordinates(5, 3, 25, 0, 0, 0, 2 * Math.PI);
        Scene scene = new Scene(new Group());
        stage.setTitle("Pie Chart");
        stage.setWidth(500);
        stage.setHeight(500);
        ArrayList<PieChart.Data> data = new ArrayList<>(coordinates.length);
        double countOfYs = Arrays.stream(coordinates).mapToDouble(point -> point.y).count();
        Set<Float> xCategorySet = Arrays.stream(coordinates).map(point -> point.x).collect(Collectors.toSet());


        for (Float xCategory : xCategorySet) {
            data.add(new PieChart.Data(
                    String.valueOf(xCategory),
                    Arrays.stream(coordinates)
                            .filter(point -> point.x == xCategory)
                            .mapToDouble(point -> point.y)
                            .count() / countOfYs));
        }

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(data);
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Distribution by X");

        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}