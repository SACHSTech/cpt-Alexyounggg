package cpt;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
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

        TableView<Players> table = new TableView<Players>();

        
TableColumn<Players, Integer> rankColumn = new TableColumn<>("Rank");
rankColumn.setCellValueFactory(new PropertyValueFactory<>("rank"));

TableColumn<Players, String> nameColumn = new TableColumn<>("Name");
nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

TableColumn<Players, Integer> threesMadeColumn = new TableColumn<>("Threes Made");
threesMadeColumn.setCellValueFactory(new PropertyValueFactory<>("threesMade"));

TableColumn<Players, Integer> threesAttemptedColumn = new TableColumn<>("Threes Attempted");
threesAttemptedColumn.setCellValueFactory(new PropertyValueFactory<>("threesAttempted"));

TableColumn<Players, Double> threesPercentColumn = new TableColumn<>("Threes Percent");
threesPercentColumn.setCellValueFactory(new PropertyValueFactory<>("threePercent"));

table.getColumns().addAll(rankColumn, nameColumn, threesMadeColumn, threesAttemptedColumn, threesPercentColumn);


ObservableList<Players> dataTable = FXCollections.observableArrayList(yes);
    
table.setItems(dataTable);


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
            newDataSeries.getData().add(new XYChart.Data<>(yes.get(i).getThreesAttempted(), yes.get(i).getThreePercent()));

            
        }
        scatterChart.getData().add(dataSeries);
        newScatterChart.getData().add(newDataSeries);

        scatterChart.setVisible(false);
        newScatterChart.setVisible(false);

       

        Button secondButton = new Button("Graph 1");
         secondButton.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
                scatterChart.setVisible(true);
                newScatterChart.setVisible(false);
                table.setVisible(false);
            }
        });

        Button button = new Button("Graph 2");
         button.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
            scatterChart.setVisible(false);
            newScatterChart.setVisible(true);
            table.setVisible(false);
    }
        });

            
     Button thirdButton = new Button("Table");
     thirdButton.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent event) {
            scatterChart.setVisible(false);
            newScatterChart.setVisible(false);
            table.setVisible(true);
        }
    });

        StackPane spLineChart = new StackPane();
        spLineChart.getChildren().addAll(scatterChart, newScatterChart, table);

        StackPane spButton = new StackPane();
        spButton.getChildren().add(button);
        spButton.setAlignment(button, Pos.BOTTOM_RIGHT);

        StackPane sprButton = new StackPane();
        spButton.getChildren().add(secondButton);
        spButton.setAlignment(secondButton, Pos.BOTTOM_LEFT);

        StackPane sppButton = new StackPane();
        spButton.getChildren().add(thirdButton);
        spButton.setAlignment(thirdButton, Pos.BOTTOM_CENTER);

        VBox vbox = new VBox(5);
        vbox.getChildren().addAll(spLineChart, spButton, sprButton, sppButton);

        Scene scene  = new Scene(vbox,800,600);
              

        primaryStage.setScene(scene);
        primaryStage.show();
}
}
