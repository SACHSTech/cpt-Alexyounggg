import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class ScatterPlot extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create the x-axis and y-axis
        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("X");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Y");

        // Create the scatter chart
        ScatterChart<Number, Number> scatterChart = new ScatterChart<>(xAxis, yAxis);
        scatterChart.setTitle("Scatter Plot Example");

        // Create the data points
        List<XYChart.Data<Number, Number>> dataPoints = new ArrayList<>();
        for (int i = 0; i < stats.length; i++){
            
        }
        dataPoints.add(new XYChart.Data<>(1, 2));
        dataPoints.add(new XYChart.Data<>(3, 4));
        dataPoints.add(new XYChart.Data<>(5, 6));
        dataPoints.add(new XYChart.Data<>(7, 8));

        // Add the data points to the chart
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.getData().addAll(dataPoints);
        scatterChart.getData().add(series);

        // Show the chart
        Scene scene = new Scene(scatterChart, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
