package projectjava2020;


public class Model {
    String name;
    int time;
    int score;
    
    public Model(){
        
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setBestTime(int time){
        this.time = time;
    }
    
    public void setBestScore(int score){
        this.score = score;
    }
    
    public String getName(){
        return name;
    }
    
    public int getBestTime(){
        return time;
    }
    
    public int getBestScore(){
        return score;
    }
    
    
    
}
