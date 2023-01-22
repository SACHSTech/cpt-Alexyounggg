package cpt;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Test extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Define the x and y axis
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Three Point Makes");
        yAxis.setLabel("Thre Point Percent");

        // Create the line chart
        ScatterChart<Number, Number> scatterChart = new ScatterChart<>(xAxis, yAxis);
        scatterChart.setTitle("Data Plot");

        // Create a data series to hold the data
        XYChart.Series<Number, Number> dataSeries = new XYChart.Series<>();

        // Read data from csv file and add it to the data series
        try {
            File file = new File("C:\\Users\\Alex Young\\git\\cpt-Alexyounggg\\src\\cpt\\ThreePointPercentEditted.csv\\");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");
                dataSeries.getData().add(new XYChart.Data<>(Integer.parseInt(values[2]), Double.parseDouble(values[4])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Add the data series to the line chart
        scatterChart.getData().add(dataSeries);

        // Show the line chart
        Scene scene = new Scene(scatterChart, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();

         // Create a button to display another graph
         Button button = new Button("Show Another Graph");
         button.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
                 // Define new x and y axis
                 NumberAxis newXAxis = new NumberAxis();
                 NumberAxis newYAxis = new NumberAxis();
                 newXAxis.setLabel("Rebounds");
                 newYAxis.setLabel("Assists");
 
                 // Create a new scatter chart
                 ScatterChart<Number, Number> newScatterChart = new ScatterChart<>(newXAxis, newYAxis);
                 newScatterChart.setTitle("Another Data Plot");
 
                 // Create a new data series to hold the new data
                 XYChart.Series<Number, Number> newDataSeries = new XYChart.Series<>();
 
                 // Read data from a new csv file and add it to the new data series
                 try {
                    File file = new File("C:\\Users\\Alex Young\\git\\cpt-Alexyounggg\\src\\cpt\\ThreePointPercentEditted.csv\\");
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        String[] values = line.split(",");
                        newDataSeries.getData().add(new XYChart.Data<>(Integer.parseInt(values[3]), Double.parseDouble(values[4])));
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
 
                  // Add the data series to the line chart
                 newScatterChart.getData().add(newDataSeries);        
    }
     });
     }
    }

        
