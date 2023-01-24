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
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;


import java.util.ArrayList;




public class Main extends Application {

    ArrayData arrayData = new ArrayData();
    ArrayData arrayDataTwo = new ArrayData();
    Sorter sorter = new Sorter();

    ArrayList<Players> yes = arrayData.threePercent();
    ArrayList<Players> reverse = arrayDataTwo.reverseThreePercent();
    
    int [] reverseShooting = new int [yes.size()];
    
    


    private Label label;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Setting stage title
        primaryStage.setTitle("Best Three Point Shooters 2021-2022 Season");

        // Creating table 
        TableView<Players> table = new TableView<Players>();

        // Creating search bar
        TextField searchField = new TextField();
        searchField.setPromptText("Enter player");  
        
        
    // Creating title for program
    label = new Label("Best shooters in 2021-2022 Season");

    label.setStyle("-fx-font-size: 30px; -fx-font-weight: bold;-fx-text-alignment: center;");
      

// Creating columsn for the table
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


// Adding the data onto the table
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

        for (int i = 0; i < yes.size(); i++){
            reverseShooting[i] = yes.get(i).getThreesMade();
        }

        sorter.mergeSort(reverseShooting);

       


        // Define the axes
        CategoryAxis xBarAxis = new CategoryAxis();
        xBarAxis.setLabel("Players");
        NumberAxis yBarAxis = new NumberAxis();
        yBarAxis.setLabel("Threes Made");
        CategoryAxis xBarAxisTwo = new CategoryAxis();
        xBarAxis.setLabel("Players");
        NumberAxis yBarAxisTwo = new NumberAxis();
        yBarAxis.setLabel("Threes Made");
        CategoryAxis xBarAxisThree = new CategoryAxis();
        xBarAxis.setLabel("Players");
        NumberAxis yBarAxisThree = new NumberAxis();
        yBarAxis.setLabel("Threes Made");
        CategoryAxis xBarAxisFour = new CategoryAxis();
        xBarAxis.setLabel("Players");
        NumberAxis yBarAxisFour = new NumberAxis();
        yBarAxis.setLabel("Threes Made");


        // Create a BarChart object
        BarChart<String, Number> barChart = new BarChart<>(xBarAxis, yBarAxis);
        BarChart<String, Number> barChartTwo = new BarChart<>(xBarAxisTwo, yBarAxisTwo);
        BarChart<String, Number> barChartThree = new BarChart<>(xBarAxisThree, yBarAxisThree);
        BarChart<String, Number> barChartFour = new BarChart<>(xBarAxisFour, yBarAxisFour);

        
        barChart.setTitle("Three Points Made 2021-2022 Season");
        barChartTwo.setTitle("Three Points Made 2021-2022 Season");
        barChartThree.setTitle("Three Points Made 2021-2022 Season");
        barChartFour.setTitle("Three Points Made 2021-2022 Season");

        // Create a series
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        XYChart.Series<String, Number> seriesTwo = new XYChart.Series<>();
        XYChart.Series<String, Number> seriesThree = new XYChart.Series<>();
        XYChart.Series<String, Number> seriesFour = new XYChart.Series<>();
        series.setName("Threes Made");
        seriesTwo.setName("Threes Made");
        seriesThree.setName("Threes Made");
        seriesFour.setName("Threes Made");

        // Add data to the series

        for (int i = 0; i < yes.size(); i++){
            series.getData().add(new XYChart.Data<>(yes.get(i).getName(), yes.get(i).getThreesMade()));
        }

        for (int i = 0; i < 11; i++){
            seriesTwo.getData().add(new XYChart.Data<>(yes.get(i).getName(), yes.get(i).getThreesMade()));
        }

        for (int i = 0; i < 5; i++){
            seriesThree.getData().add(new XYChart.Data<>(yes.get(i).getName(), yes.get(i).getThreesMade()));
        }

        for (int i = 0; i < yes.size(); i++){
            seriesFour.getData().add(new XYChart.Data<>(reverse.get(i).getName(), reverseShooting[i]));
        }

        

        // Add the series to the chart
        barChart.getData().add(series);
        barChartTwo.getData().add(seriesTwo);
        barChartThree.getData().add(seriesThree);
        barChartFour.getData().add(seriesFour);

        

  // Create checkboxes
  CheckBox topTenCheckbox = new CheckBox("Top 10");
 CheckBox topFiveCheckbox = new CheckBox("Top 5");
 CheckBox reverseCheckbox = new CheckBox ("Reverse");
 
 


  // Add an event handler to the checkbox
      topTenCheckbox.setOnAction(e -> {
          if (topTenCheckbox.isSelected()) {
      
      
      barChartTwo.setVisible(true);
      barChart.setVisible(false);
      barChartThree.setVisible(false);
      barChartFour.setVisible(false);

      if(topFiveCheckbox.isSelected()){
        topFiveCheckbox.setSelected(false);
      }

      if(reverseCheckbox.isSelected()){
        reverseCheckbox.setSelected(false);
    }
  } 
  
  else {
      barChartTwo.setVisible(false);
      barChart.setVisible(true);
      barChartThree.setVisible(false);
      barChartFour.setVisible(false);
      
  }
});

topFiveCheckbox.setOnAction(e -> {
    if (topFiveCheckbox.isSelected()) {


barChartTwo.setVisible(false);
barChart.setVisible(false);
barChartThree.setVisible(true);
barChartFour.setVisible(false);

if(topTenCheckbox.isSelected()){
  topTenCheckbox.setSelected(false);
}

if(reverseCheckbox.isSelected()){
    reverseCheckbox.setSelected(false);
}
} 

else {
barChartTwo.setVisible(false);
barChart.setVisible(true);
barChartThree.setVisible(false);
barChartFour.setVisible(false);

}
});

// Add an event handler to the checkbox
reverseCheckbox.setOnAction(e -> {
    if (reverseCheckbox.isSelected()) {


barChartTwo.setVisible(false);
barChart.setVisible(false);
barChartThree.setVisible(false);
barChartFour.setVisible(true);

if(topTenCheckbox.isSelected()){
   topTenCheckbox.setSelected(false);
 }

 if(topFiveCheckbox.isSelected()){
   topFiveCheckbox.setSelected(false);
 }
} 

else {
barChartTwo.setVisible(false);
barChart.setVisible(true);
barChartThree.setVisible(false);
barChartFour.setVisible(false);

}
});

        // Making checkboxes invisible on default
        barChart.setVisible(true);
        barChartTwo.setVisible(false);
        barChartThree.setVisible(false);
        barChartFour.setVisible(false);
        



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
    

        // Create the scatter chart
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

        // Adding data to scatter chart
        scatterChart.getData().add(dataSeries);
        newScatterChart.getData().add(newDataSeries);

        scatterChart.setVisible(true);
        newScatterChart.setVisible(false);
        
        


        ObservableList<String> options = FXCollections.observableArrayList("Table", "Scatter Graph 1", "Scatter Graph 2", "Bar Graph");

        // Create a ChoiceBox
        ChoiceBox<String> choiceBox = new ChoiceBox<String>(options);

        choiceBox.setValue("Table");

        // Prompts for when choicebox is selected
        choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.equals("Table")){
                scatterChart.setVisible(false);
                newScatterChart.setVisible(false);
                table.setVisible(true);
                barChart.setVisible(false);
                barChartTwo.setVisible(false);
                barChartThree.setVisible(false);
                topTenCheckbox.setVisible(false);
                topFiveCheckbox.setVisible(false);
                barChartTwo.setVisible(false);
                barChartThree.setVisible(false);
                reverseCheckbox.setVisible(false);
            }
            else if (newValue.equals("Scatter Graph 1")) {
                scatterChart.setVisible(true);
                newScatterChart.setVisible(false);
                table.setVisible(false);
                barChart.setVisible(false);
                barChartTwo.setVisible(false);
                barChartThree.setVisible(false);
                topTenCheckbox.setVisible(false);
                topFiveCheckbox.setVisible(false);
                reverseCheckbox.setVisible(false);

            } else if (newValue.equals("Scatter Graph 2")) {
                scatterChart.setVisible(false);
                newScatterChart.setVisible(true);
                table.setVisible(false);
                barChart.setVisible(false);
                barChartTwo.setVisible(false);
                barChartThree.setVisible(false);
                topTenCheckbox.setVisible(false);
                topFiveCheckbox.setVisible(false);
                reverseCheckbox.setVisible(false);

            } else if (newValue.equals("Bar Graph")) {
                scatterChart.setVisible(false);
                newScatterChart.setVisible(false);
                table.setVisible(false);
                barChart.setVisible(true);
                barChartTwo.setVisible(false);
                barChartThree.setVisible(false);
                topTenCheckbox.setVisible(true);
                topFiveCheckbox.setVisible(true);
                barChartTwo.setVisible(false);
                barChartThree.setVisible(false);
                reverseCheckbox.setVisible(true);
            }
          
        });

        
        // Adding buttons 
        Button secondButton = new Button("Scatter Plot 1");
         secondButton.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
                scatterChart.setVisible(true);
                newScatterChart.setVisible(false);
                
            }
        });

        Button button = new Button("Scatter Plot 2");
         button.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
            scatterChart.setVisible(false);
            newScatterChart.setVisible(true);
            
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
            barChartTwo.setVisible(false);
            barChartThree.setVisible(false);
            topTenCheckbox.setVisible(false);
            topFiveCheckbox.setVisible(false);
            reverseCheckbox.setVisible(false);
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
            topTenCheckbox.setVisible(true);
            topFiveCheckbox.setVisible(true);
            reverseCheckbox.setVisible(true);
            barChartTwo.setVisible(false);
            barChartThree.setVisible(false);
        }
    });
    
    HBox search = new HBox();
    search.getChildren().add(searchField);
    search.setAlignment(Pos.TOP_RIGHT);

    StackPane stackPaneScatter = new StackPane();
    stackPaneScatter.getChildren().addAll(scatterChart, newScatterChart);

    StackPane stackPaneBar = new StackPane();
    stackPaneBar.getChildren().addAll(barChart, barChartTwo, barChartThree, barChartFour);

    HBox hbox = new HBox();
    hbox.getChildren().addAll(topTenCheckbox, topFiveCheckbox, reverseCheckbox);

    /* 
        StackPane spLineChart = new StackPane();
        spLineChart.getChildren().addAll(scatterChart, newScatterChart, table, barChart, barChartTwo, barChartThree, barChartFour);
        */


        TabPane tabPane = new TabPane();
        
        // First tab; table
        Tab tableTab = new Tab("Table");

        tableTab.setContent(new VBox(table, search));

        // Second tab; scatter chart
        Tab scatterTab = new Tab("Scatter Chart");
        scatterTab.setContent(new VBox(stackPaneScatter, secondButton, button));

        Tab barTab = new Tab ("Bar Graph");
        barTab.setContent(new VBox(stackPaneBar, hbox));

        // Both tabs
        tabPane.getTabs().addAll(tableTab, scatterTab, barTab);


        HBox choice = new HBox();
        choice.getChildren().add(choiceBox);
        choice.setAlignment(Pos.TOP_RIGHT);
    

        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(search, label, tabPane, choice);

        Scene scene  = new Scene(vbox, 800, 600);
              

        primaryStage.setScene(scene);
        primaryStage.show();
}

    
}
