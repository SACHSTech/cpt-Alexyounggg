package cpt;

public class Players {
    
    private int rank;
    private String name;
    private int threesMade;
    private int threesAttempted;
    private double threePercent;

    public Players (int rank, String name, int threesMade, int threesAttempted, double threePercent) {
        this.rank = rank;
        this.name = name;
        this.threesMade = threesMade;
        this.threesAttempted = threesAttempted;
        this.threePercent = threePercent;
      
        
    }

    public int geRank() {
        return this.rank;

    }
    
    public String getName() {
        return this.name;
    }

    public int getThreesMade() {
        return this.threesMade;

    }

    public int getThreesAttempted() {
        return this.threesAttempted;

    }
    
    public Double getThreePercent() {
        return this.threePercent;
    }

    

   
    
}
