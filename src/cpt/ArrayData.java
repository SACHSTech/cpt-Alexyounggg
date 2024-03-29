package cpt;

import java.io.FileReader;
import java.util.ArrayList;
import java.io.*;

public class ArrayData {

    ArrayList<Players> stats = new ArrayList<>();

    /**
     * Allows program to read csv file
     */
    public ArrayData(){

 String line;
 String csvSplitBy = ",";
  

    try {
BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Alex Young\\git\\cpt-Alexyounggg\\src\\cpt\\ThreePoint.csv\\" )); 

    
while ((line = reader.readLine()) != null) {
    String[] row = line.split(csvSplitBy);

   
            int rank = Integer.parseInt(row[0]);
            String name = row [1];
            int threesMade = Integer.parseInt(row[2]);
            int threesAttempted = Integer.parseInt(row[3]);
            double threesPercent = Double.parseDouble(row[4]);
            Players numbers = new Players (rank, name, threesMade, threesAttempted, threesPercent);
            stats.add(numbers);


       
    }
    reader.close();
    

    }
    
    catch (Exception e){
        e.printStackTrace();
    }

 
    
    }

    /**
     * Gets the array of data points
     * @return array of shooting data
     */
    public ArrayList<Players> threePercent(){

        ArrayList <Players> statsTwo = new ArrayList <Players>();

        for (int i = 0; i < stats.size(); i++){
            statsTwo.add(stats.get(i));

        }

        return statsTwo;
    }

    /**
     * Gets the array of data points reversed
     * @return array of shooting data
     */
    public ArrayList<Players> reverseThreePercent(){

        ArrayList <Players> statsThree = new ArrayList <Players>();

        for (int i = stats.size() - 1; i >= 0 ; i--){
            statsThree.add(stats.get(i));

        }

        return statsThree;
    }
    
}




