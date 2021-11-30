package projectjava2020;
import DataBase.DBController;
import DataBase.DbConnection;
import DataBase.Player;
import DataBase.PlayerDaoImplementation;
import GUI.CardPanel;
import GUI.GameGui;
import GUI.InfoPanel;
import GUI.PromptPanel;
import GUI.TopMenu;
import java.sql.SQLException;

/**
 *auti i klasi elegxei oles tis klaseis pou exou na kanoun me to gui
 */
public class Controller {
    private final CardPanel cardpanel;
    private final InfoPanel infopanel;
    private final TopMenu topmenu;
    private final Model model;
    DbConnection dbconnection;
    DBController dbController;
    PromptPanel prompt;    
    String values[];
    String name;
    int besttime,bestscore;
    
    
    
    public Controller(CardPanel cardpanel,InfoPanel infopanel,TopMenu topmenu,Model model){
        this.cardpanel = cardpanel;
        this.infopanel = infopanel;
        this.topmenu = topmenu;
        this.model = model;
    }
    
   /**
    *to proto parathiro pou anoigei kai sindesi me tin basi
    */
    public void makeGui() throws SQLException{
        giveText();
        giveMatches();
        GameGui gamegui = new GameGui(cardpanel,infopanel,topmenu);
        dbconnection = DbConnection.getInstance("tp5006", "petros123", "players");
        dbController = new DBController(dbconnection);
//        prompt = PromptPanel.getInstance();

        /**
         * perimenoume mexri na patithei to enter oste na paroume to onoma kai to mode
         * i prompt epistrefei mia array me values[0]=to onoma tou paikti kai values[1]=to mode tou paixnidiou
         */
//        values = prompt.addListener();
//        while((values[0] == null || values[0].equals(""))){
//            values = prompt.addListener();
//        }
        
        //molis exoume ta dedomena ksekinaei to paixnidi
//        addUser(values[0]);
//        takeData(values[0]);
//        prompt.setVisible(false);
        //gamegui.createGui(values[1]);
        setName();
        setBestTime();
        setBestScore();
        gamegui.createGui("easy");
        
    }
    
    /**
     *eisagei ton xristi an den iparxei
     */
    public void addUser(String name)throws SQLException{       
        dbController.insertUser(name);
    }
    
    /**
     * pairnei ta dedomana me dao
     */
    public void takeData(String username) throws SQLException{
        PlayerDaoImplementation playerDao = new PlayerDaoImplementation(dbController.retrieveAllUsers());
        Player player = playerDao.getSpecificPlayer(username);
        name = player.getName();
        besttime = player.getBestTime();
        bestscore = player.getBestScore();
        
    }
    
    /**
     * dinei to model ta dedomena
     */
    public void setName(){
        this.model.setName(name);
    }
    
    public void setBestTime(){
        this.model.setBestTime(besttime);
    }
    
    public void setBestScore(){
        this.model.setBestTime(besttime);
    }
    
    public void updateView(){
        this.infopanel.showData(this.model);
    }
    
    /**
     * dinei stin cardpanel to JLabel "clicks" tou info gia na enimeronei ton arithmo koympion
     */
    public void giveText(){
        cardpanel.getText(infopanel.getClicks());
    }
    
    /**
     * dinei ton pinaka me ta jlabels ston cardpanel gia na enimeronei pote iparxei ena match
     * stis kartes
     */
    public void giveMatches(){
        cardpanel.getMatches(infopanel.getMatches());
    }

    
    
}