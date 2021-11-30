package GUI;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * afti i klasi ftiaxnei to ketriko JFrame me basi to cardpanel kai infopanel poy perasame
 */

public final class GameGui extends JFrame{
  
    private static GameGui instance;
    long time;
    static CardPanel cardpanel;
    static InfoPanel infopanel;
    static TopMenu topmenu;

    
    public GameGui(CardPanel cardpanel,InfoPanel infopanel,TopMenu topmenu) {
        super("Memory Card Game");
        GameGui.cardpanel = cardpanel;
        GameGui.infopanel = infopanel; 
        GameGui.topmenu = topmenu;    
        
    }   
    /**
     * ftiaxnoume to gui
     */
    public void createGui(String mode) {
        cardpanel.initComponets(mode);        
        
        this.add(cardpanel,BorderLayout.WEST);
        this.add(infopanel,BorderLayout.CENTER);
        this.setJMenuBar(topmenu.getMenuBar());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public static GameGui getInstance(){
        if (instance != null) {            
            return instance;
        }
        instance = new GameGui(GameGui.cardpanel,GameGui.infopanel,GameGui.topmenu);
        return instance;
    } 

    

}

