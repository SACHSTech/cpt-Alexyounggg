package cpt;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.*;

public class ArrayData {

public String line = "";
public int count = 0;
public String csvSplitBy = ",";
public ArrayList<Players> stats = new ArrayList<>();
    
    public void dataReader(){

    try {
BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Alex Young\\git\\cpt-Alexyounggg\\src\\cpt\\ThreePointPercentEditted.csv\\" )); 

    
while ((line = reader.readLine()) != null) {
    String[] row = line.split(csvSplitBy);

    if (count != 0){
        for (int i = 0; i < row.length; i++){
            int rank = Integer.parseInt(row[0]);
            String name = row [1];
            int threesMade = Integer.parseInt(row[2]);
            int threesAttempted = Integer.parseInt(row[3]);
            double threesPercent = Double.parseDouble(row[4]);
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
    public int getLength(){
        return stats.size();
    }

    public ArrayList<Players> getArray(){
        return this.stats;
    }
}



