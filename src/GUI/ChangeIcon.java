package GUI;
import DataBase.DBController;
import DataBase.DbConnection;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import static projectjava2020.ProjectJava2020.dbconnection;

//klasi poy einai ipefthini na allazei ta eikonidia kathe fora poy patiete koympi
//na vriskei pote o xristis vrike kapoion sindiasmo
//kai na enimeronei to label ton sindiasmon kai na kanei update tin basi otan o 
// xristis vriskei oloys toys sindiasmoys
public class ChangeIcon{
    
    public JButton button;
    public JLabel[] matches;
    public static JButton[] activebtns = new JButton[2];
    public static int playerm,activecards=0;
    public int mode;
    public long time,timepassed;
    DBController dbController;
    private HistoryFrame history;
    List<JButton> foundbuttons = new ArrayList<>();
    private static String historytext="";
    
    
    public ChangeIcon(JLabel[] matches,int mode){
        this.matches = matches;
        this.mode = mode;
        history = HistoryFrame.getInstance();
        //history.showHistory();        
        //this.initComponets();
    }
    
    
    public void initComponets(){ 
        
        //anoigei 2 kartes tin fora kai prostheti sto activebtns to anoigmeno koumpi
        if(activecards<2){
            activebtns[activecards] = button;
            button.setIcon(new ImageIcon("src/Icons/"+button.getName()));
            button.setBorder(BorderFactory.createLineBorder(Color.white, 2));
            activecards++;            
        }else{
            for(int i=0;i<=1;i++){
                activebtns[i].setBorder(BorderFactory.createLineBorder(Color.black, 2));
                activebtns[i].setIcon(new ImageIcon("src/Icons/back.png"));
            }
            button.setIcon(new ImageIcon("src/Icons/"+button.getName()));
            button.setBorder(BorderFactory.createLineBorder(Color.white, 2));
            activecards=0;
            activebtns[activecards++] = button;
        }
        
        //otan exoun anoiksei kai oi 2 kartes elegxei an vrike ton sindiasmo kai to
        //prostheti sto history
        if(activecards==2){           
            if(activebtns[0].getName().equals(activebtns[1].getName())){
                String btnname = activebtns[0].getName();
                String text = btnname.substring(0, btnname.length() - 4);
                historytext+="Vrethike to: "+text+"\n\n";
                history.AddToHistory(historytext);
                foundbuttons.add(activebtns[0]);
                foundbuttons.add(activebtns[1]);
                matches[0].setText("SCORE: "+(++playerm)+"/"+mode);                
                //System.out.println("Vrikes");
            }       
        }
        
        //trexei tin lista me tis kartes poy exoume vrei kai kanei ta eikonidia tous na menoun
        //oste na kseroyme oti ta exoyme vrei
        for(JButton btn : foundbuttons){
            btn.setIcon(new ImageIcon("src/Icons/"+btn.getName()));
            btn.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        }        
        
        /**
         *otan o paiktis vrei olous tous sindiasmous enimeronete i basi
         */
        if(playerm==mode){
            Date t = new java.util.Date();
            timepassed = (t.getTime()-time)/1000;
            
            dbconnection = DbConnection.getInstance("tp5006", "petros123", "players");
            dbController = new DBController(dbconnection);
            
            try {
                dbController.updateUser(playerm, (int) timepassed);
            }catch (SQLException ex) {
            }
            
            
        }
        
    } 
    
   public void setTimeStart(long time){
       this.time = time;
   }
   
   public void setButton(JButton btn){
       this.button = btn;
       this.initComponets();
   }
    
}

