package GUI;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class HistoryFrame extends JFrame{
     private static HistoryFrame instance;
     private JTextArea area;
    
    public HistoryFrame(){
        super("History");        
        this.initComponets();
    }
    
    public void initComponets(){
        area=new JTextArea("  Log is here   ");  
        area.setBounds(0,0, 250,560);
        area.setEditable(false);
        this.add(area); 
        this.setLayout(null);
        this.setSize(250, 560);
        this.setDefaultCloseOperation(HistoryFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(false);
    }
    
    public void hideHistory(){
        this.setVisible(false);
    }
    
    public void showHistory(){
        this.setVisible(true);
    }
    
    public void AddToHistory(String text){
        area.setText(text);
    }
    
    public static HistoryFrame getInstance(){
        if (instance != null) {            
            return instance;
        }
        instance = new HistoryFrame();
        return instance;
    } 
}
