package cpt;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.*;

public class ArrayData {

    public static void main(String[] args) {

String line = "";
int count = 0;
String csvSplitBy = ",";
ArrayList<Players> stats = new ArrayList<>();

    try {
BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Alex Young\\git\\cpt-Alexyounggg\\src\\cpt\\ThreePointPercent.csv\\" )); 

    
while ((line = reader.readLine()) != null) {
    String[] row = line.split(csvSplitBy);

    if (count != 0){
        for (int i = 0; i < row.length; i+=13){
            int rank = Integer.parseInt(row[0]);
            String name = row [1];
            int threesMade = Integer.parseInt(row[2]);
            int threesAttempted = Integer.parseInt(row[3]);
            int threesPercent = Integer.parseInt(row[4]);
            Players numbers = new Players (rank, name, threesMade, threesAttempted, threesPercent);
            stats.add(numbers);

        }
    }
    count ++;
}
    }
    
    catch (Exception e){
        e.printStackTrace();
    }

 
    }
}

