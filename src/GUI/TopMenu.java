package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *afti i klasi ftiaxnei to panel tou top Menu
 */
public final class TopMenu extends JPanel{
    
    private static TopMenu instance;
    JMenu a,b,c,submenu;
    JMenuBar mb;
    JMenuItem i1,i2,i3,i4,i5,i6;
    
    
    public TopMenu(){
        this.initComponets();
        this.addListeners();
    }
    
    public void initComponets(){
        mb=new JMenuBar();
        
        a=new JMenu("Game");
        i1=new JMenuItem("New Game");  
        i2=new JMenuItem("Restart");
        i3=new JMenuItem("Exit");
        
        b=new JMenu("Options");
        submenu=new JMenu("History");        
        i4=new JMenuItem("Show History");
        i5=new JMenuItem("Hide History");
        
        c=new JMenu("Help");
        i6=new JMenuItem("About");        
        
        submenu.add(i4);
        submenu.add(i5);
        
        a.add(i1);
        a.add(i2);
        a.add(i3);
        
        b.add(submenu);
        
        c.add(i6);
        
        mb.add(a);
        mb.add(b);
        mb.add(c);
        
    }
    
    //edo dimiourgountai ta listeners gia kathe menuitem
    private void addListeners() {
        HistoryFrame history = HistoryFrame.getInstance();
        i1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ev) {
        System.out.println("new game");
      }
    });
        
       i2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ev) {
        System.out.println("restart");
      }
    });
       
       i3.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ev) {
          System.exit(0);
          System.out.println("exit");
      }
    });
       
       i4.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ev) {
          history.showHistory();
      }
    });
       
       i5.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ev) {
          history.hideHistory();
      }
    });      
       
        
    }
    
   
    
    public JMenuBar getMenuBar(){
        return mb;
    }
    
    public static TopMenu getInstance(){
        if (instance != null) {            
            return instance;
        }
        instance = new TopMenu();
        return instance;
    } 

    

    
}
