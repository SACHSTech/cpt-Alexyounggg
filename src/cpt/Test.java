package cpt;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Test extends Application {
    
    

  @Override
  public void start(Stage stage) {

    
    // Set up x and y axes
    NumberAxis xAxis = new NumberAxis();
    xAxis.setLabel("Three point percent");
    NumberAxis yAxis = new NumberAxis();
    yAxis.setLabel("Three Point Makes");

    // Create scatter chart
    ScatterChart<Number, Number> scatterChart = new ScatterChart<>(xAxis, yAxis);
    scatterChart.setTitle("Three point percent vs Makes");

    // Add data to chart
    XYChart.Series<Number, Number> series = new XYChart.Series<>();


    series.getData().add(new XYChart.Data<>(1, 2));
    series.getData().add(new XYChart.Data<>(3, 4));
    series.getData().add(new XYChart.Data<>(5, 6));
    scatterChart.getData().add(series);

    // Create buttons for sorting data
    Button sortXButton = new Button("Sort by X");
    sortXButton.setOnAction(e -> sortByX(scatterChart));
    Button sortYButton = new Button("Sort by Y");
    sortYButton.setOnAction(e -> sortByY(scatterChart));

    // Create layout for buttons and chart
    HBox layout = new HBox(sortXButton, sortYButton, scatterChart);

    // Show the scene
    stage.setScene(new Scene(layout));
    stage.show();
  }

  private void sortByX(ScatterChart<Number, Number> scatterChart) {
    // Sort data by x value
    
  }

  private void sortByY(ScatterChart<Number, Number> scatterChart) {
    // Sort data by y value
  }

  public static void main(String[] args) {
    launch(args);
  }
}
