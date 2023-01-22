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
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.input.MouseEvent;


public class Test extends Application {

    private Label label;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Define the x and y axis
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        NumberAxis xxAxis = new NumberAxis();
        NumberAxis yyAxis = new NumberAxis();
        xAxis.setLabel("Three Point Makes");
        yAxis.setLabel("Thre Point Percent");
        xxAxis.setLabel("Three Point Attemps");
        yyAxis.setLabel("Thre Point Percent");

        // Create the line chart
        ScatterChart<Number, Number> scatterChart = new ScatterChart<>(xAxis, yAxis);
        ScatterChart<Number, Number> newScatterChart = new ScatterChart<>(xxAxis, yyAxis);
        scatterChart.setTitle("Three Point Makes vs Percent");
        newScatterChart.setTitle("Three Point Attempts vs Makes");

        // Create a data series to hold the data
        XYChart.Series<Number, Number> dataSeries = new XYChart.Series<>();
        XYChart.Series<Number, Number> newDataSeries = new XYChart.Series<>();
        dataSeries.setName("Best shooters");
        newDataSeries.setName("Best shooters");

        // Read data from csv file and add it to the data series
        try {
            File file = new File("C:\\Users\\Alex Young\\git\\cpt-Alexyounggg\\src\\cpt\\ThreePointPercentEditted.csv\\");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");
                dataSeries.getData().add(new XYChart.Data<>(Integer.parseInt(values[2]), Double.parseDouble(values[4]), values[1]));
                newDataSeries.getData().add(new XYChart.Data<>(Integer.parseInt(values[3]), Double.parseDouble(values[4]), values[1]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Add the data series to the line chart
        scatterChart.getData().add(dataSeries);
        newScatterChart.getData().add(newDataSeries);

        for (XYChart.Data<Number, Number> data : dataSeries.getData()) {
            StackPane stackPane = (StackPane) data.getNode();
            Label label = new Label(.getName());
            stackPane.getChildren().add(label);
        }

        label = new Label();

        newScatterChart.setVisible(false);
        

         // Create a button to display another graph
         Button button = new Button("Show Another Graph");
         button.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {

                if (scatterChart.isVisible()) {
                    scatterChart.setVisible(false);
                    newScatterChart.setVisible(true);
                } else {
                    scatterChart.setVisible(true);
                    newScatterChart.setVisible(false);
                }
            }
    
     });
     
     StackPane spLineChart = new StackPane();
     spLineChart.getChildren().addAll(scatterChart, newScatterChart);

     StackPane spButton = new StackPane();
        spButton.getChildren().add(button);
   

        VBox vbox = new VBox(5);
        vbox.getChildren().addAll(spLineChart, spButton);

     
        
        Scene scene  = new Scene(vbox,800,600);
              

        primaryStage.setScene(scene);
        primaryStage.show();
     }
    }

        
