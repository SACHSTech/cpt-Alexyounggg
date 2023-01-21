import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            dataPoints.add(new XYChart.Data<>(r.nextDouble()*10, r.nextDouble()*10));
        }

        // Add the data points to the chart
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        for (XYChart.Data<Number, Number> data : dataPoints) {
            series.getData().add(data);
        }
        scatterChart.getData().add(series);

        // Show the chart
        Scene scene = new Scene(scatterChart, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
