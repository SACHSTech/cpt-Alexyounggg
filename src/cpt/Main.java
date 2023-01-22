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

import java.util.ArrayList;

import cpt.ArrayData;

public class Main extends Application {

    ArrayData arrayData = new ArrayData();

    ArrayList<Players> yes = arrayData.threePercent();

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
        yAxis.setLabel("Three Point Percent");
        xxAxis.setLabel("Three Point Attemps");
        yyAxis.setLabel("Thre Point Percent");
        xAxis.setAutoRanging(false);
        xAxis.setLowerBound(100);
        xAxis.setUpperBound(300);   
    

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

        for (int i = 0; i < yes.size(); i++){
            dataSeries.getData().add(new XYChart.Data<>(yes.get(i).getThreesMade(), yes.get(i).getThreePercent()));

            
        }
        scatterChart.getData().add(dataSeries);

        scatterChart.setStyle("-fx-symbol-size: 0.001;");
        
        StackPane spLineChart = new StackPane();
        spLineChart.getChildren().addAll(scatterChart);

        VBox vbox = new VBox(5);
        vbox.getChildren().addAll(spLineChart);

        Scene scene  = new Scene(vbox,800,600);
              

        primaryStage.setScene(scene);
        primaryStage.show();
}
}
