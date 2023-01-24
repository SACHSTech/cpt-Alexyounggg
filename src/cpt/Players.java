package cpt;

public class Players {
    
    // Instance variables
    private int rank;
    private String name;
    private int threesMade;
    private int threesAttempted;
    private double threePercent;

    /**
     * Creates new instance of players class
     * 
     * @param rank - Rank in terms of three pointers
     * @param name - Player name
     * @param threesMade - Amount of Threes Made
     * @param threesAttempted - Amount of Threes Attempted
     * @param threePercent - Three point percent
     */
    public Players (int rank, String name, int threesMade, int threesAttempted, double threePercent) {
        this.rank = rank;
        this.name = name;
        this.threesMade = threesMade;
        this.threesAttempted = threesAttempted;
        this.threePercent = threePercent;
      
        
    }

    /**
     * Returns the player rank
     * 
     * @return player rank
     */
    public int getRank() {
        return this.rank;

    }
    
    /**
     * Returns the player name
     * 
     * @return player name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the three points made
     * 
     * @return three points made
     */
    public int getThreesMade() {
        return this.threesMade;

    }

    /**
     * Returns the three point attempts
     * 
     * @return three point attempts
     */
    public int getThreesAttempted() {
        return this.threesAttempted;

    }
    
    /**
     * Returns three point percent
     * 
     * @return three point percent
     */
    public Double getThreePercent() {
        return this.threePercent;
    }

    

   
    
}
