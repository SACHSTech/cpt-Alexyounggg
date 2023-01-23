package cpt;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.Scene;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

        TextField searchField = new TextField();

        
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

// Add a listener to the search field to filter the table data
searchField.textProperty().addListener((observable, oldValue, newValue) -> {
    FilteredList<Players> filteredData = new FilteredList<>(dataTable, p -> true);
    filteredData.setPredicate(person -> {
        // If the search field is empty, display all items
        if (newValue == null || newValue.isEmpty()) {
            return true;
        }
        String lowerCaseFilter = newValue.toLowerCase();
        if (person.getName().toLowerCase().contains(lowerCaseFilter)) {
            return true;
        }
        return false;
    });
    SortedList<Players> sortedData = new SortedList<>(filteredData);
    table.setItems(sortedData);
});


        //Bar Graph

        // Define the axes
        CategoryAxis xBarAxis = new CategoryAxis();
        xBarAxis.setLabel("Players");
        NumberAxis yBarAxis = new NumberAxis();
        yBarAxis.setLabel("Threes Made");
        CategoryAxis xBarAxisTwo = new CategoryAxis();
        xBarAxis.setLabel("Players");
        NumberAxis yBarAxisTwo = new NumberAxis();
        yBarAxis.setLabel("Threes Made");

        // Create a BarChart object
        BarChart<String, Number> barChart = new BarChart<>(xBarAxis, yBarAxis);
        BarChart<String, Number> barChartTwo = new BarChart<>(xBarAxisTwo, yBarAxisTwo);
        barChart.setTitle("Three Points Made 2021-2022 Season");
        barChartTwo.setTitle("Three Points Made 2021-2022 Season");

        // Create a series
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        XYChart.Series<String, Number> seriesTwo = new XYChart.Series<>();
        series.setName("Threes Made");
        seriesTwo.setName("Threes Made");

        // Add data to the series

        for (int i = 0; i < yes.size(); i++){
            series.getData().add(new XYChart.Data<>(yes.get(i).getName(), yes.get(i).getThreesMade()));
        }

        for (int i = 0; i < 11; i++){
            seriesTwo.getData().add(new XYChart.Data<>(yes.get(i).getName(), yes.get(i).getThreesMade()));
        }

        

        // Add the series to the chart
        barChart.getData().add(series);
        barChartTwo.getData().add(seriesTwo);

        

  // Create checkboxes
  CheckBox top10Checkbox = new CheckBox("Top 10");
  // Add an event handler to the checkbox
      top10Checkbox.setOnAction(e -> {
          if (top10Checkbox.isSelected()) {
      
      
      barChartTwo.setVisible(true);
      barChart.setVisible(false);
  } 
  
  else {
      barChartTwo.setVisible(false);
      barChart.setVisible(true);
      
  }
});

        top10Checkbox.setVisible(false);
        barChart.setVisible(false);
        barChartTwo.setVisible(false);



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
                barChart.setVisible(false);
                top10Checkbox.setVisible(false);
            }
        });

        Button button = new Button("Graph 2");
         button.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
            scatterChart.setVisible(false);
            newScatterChart.setVisible(true);
            table.setVisible(false);
            barChart.setVisible(false);
            top10Checkbox.setVisible(false);
    }
        });

            
     Button thirdButton = new Button("Table");
     thirdButton.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent event) {
            scatterChart.setVisible(false);
            newScatterChart.setVisible(false);
            table.setVisible(true);
            barChart.setVisible(false);
            top10Checkbox.setVisible(false);
        }
    });

    Button fourthButton = new Button("Bar graph");
     fourthButton.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent event) {
            scatterChart.setVisible(false);
            newScatterChart.setVisible(false);
            table.setVisible(false);
            barChart.setVisible(true);
            top10Checkbox.setVisible(true);
        }
    });
        StackPane spLineChart = new StackPane();
        spLineChart.getChildren().addAll(scatterChart, newScatterChart, table, barChart, barChartTwo);


        HBox search = new HBox();
        search.getChildren().add(searchField);
        search.setAlignment(Pos.TOP_RIGHT);

        

        VBox vbox = new VBox(5);
        vbox.getChildren().addAll(spLineChart, secondButton, button, thirdButton, fourthButton, search, top10Checkbox);

        Scene scene  = new Scene(vbox,800,600);
              

        primaryStage.setScene(scene);
        primaryStage.show();
}
}
