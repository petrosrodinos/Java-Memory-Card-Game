package DataBase;

//klasi gia ton paikti me ta stoixeia toy gia to paixnidi
public class Player {

    private final String name;
    private final int besttime;
    private final int bestscore;

    public Player(String name, int besttime, int bestscore) {
        this.name = name;
        this.besttime = besttime;
        this.bestscore = bestscore;
    }

    /**
     * epistrefei to onoma tou paikti
     * @return String name
     */
    public String getName() {
        return name;
    }
 
    /**
     * epistrefei ton xrono
     * @return int besttime
     */
    public int getBestTime() {
        return besttime;
    }

    /**
     * epistrefei to score
     * @return int bestscore
     */
    public int getBestScore() {
        return bestscore;
    }

    

}

