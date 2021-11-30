package projectjava2020;
import DataBase.DbConnection;
import GUI.CardPanel;
import GUI.InfoPanel;
import GUI.TopMenu;
import java.sql.SQLException;

public class ProjectJava2020 {
    public static DbConnection dbconnection;   
    
     //dimiourgia tou cardpanel,infopanel,topmenu kai perasma sto controller
     public static void main(String[] args) throws SQLException { 
        
        
       CardPanel cardpanel = CardPanel.getInstance(); //view
       InfoPanel infopanel = InfoPanel.getInstance(); //view
       TopMenu topmenu = TopMenu.getInstance();       //view
       
       Model model = new Model(); //Model
       
       Controller controller = new Controller(cardpanel,infopanel,topmenu,model); //Controller
       controller.makeGui();
       controller.updateView();
       
    }
    
}
