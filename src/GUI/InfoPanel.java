package GUI;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Timer;
import javax.swing.JLabel;
import javax.swing.JPanel;
import projectjava2020.Model;

/**
 * afti i klasi ftiaxnei to panel gia tis plirofories toy xristi
 */
public final class InfoPanel extends JPanel{
    private static InfoPanel instance;
    private JLabel name,time,clicks,matches,cmatches,besttime,bestscore;
    public int countclicks=0;
    private final JLabel[] jlabels =  new JLabel[2];
 
    
    public InfoPanel(){        
        this.initComponets();          
    }
    
    private void initComponets(){
        
        this.setBackground(Color.cyan);
        this.setPreferredSize(new Dimension(200, 250));
        this.setLayout(null);
        
        name = new JLabel("NAME: ");
        time = new JLabel("TIME: ");
        clicks = new JLabel("ROUNDS: 0");
        matches = new JLabel("SCORE: 0");
        cmatches = new JLabel("COMPUTER SCORE: 0");
        besttime = new JLabel("BEST TIME: ");
        bestscore = new JLabel("BEST CLICKS: ");
        
        Time t1 = new Time(time);
        Timer t = new Timer();
        t.schedule(t1, 1000, 1000);
     
        Dimension size = time.getPreferredSize();
        Dimension size1 = clicks.getPreferredSize();
        Dimension size2 = matches.getPreferredSize();
        Dimension size3 = besttime.getPreferredSize();
        Dimension size4 = bestscore.getPreferredSize();
        
        time.setBounds(10, 10, size.width+500, size.height);
        clicks.setBounds(10, 90, size1.width+500, size1.height);
        matches.setBounds(10, 170, size2.width+200, size2.height);
        besttime.setBounds(10, 280, size3.width+200, size3.height);
        bestscore.setBounds(10, 360, size4.width+200, size4.height);
        name.setBounds(10, 440, size4.width+200, size4.height);
        cmatches.setBounds(10, 210, size2.width+200, size2.height); 
        
        this.add(time);
        this.add(clicks);
        this.add(matches);
        //this.add(cmatches);
        this.add(besttime);
        this.add(bestscore); 
        this.add(name);
    
    }
    
     /**
     * allazei ta label gia tis plirofories toy xristi apo tis times toy model
     */
    public void showData(Model model){
        name.setText("NAME: "+model.getName());
        if(model.getBestTime()==0){
            besttime.setText("BEST TIME: -");
            bestscore.setText("BEST SCORE: -"); 
        }else{
            besttime.setText("BEST TIME: "+model.getBestTime());
            bestscore.setText("BEST SCORE: "+model.getBestScore());
        }        
    }
    
    public JLabel[] getMatches(){
        jlabels[0] = matches;
        jlabels[1] = cmatches;
        return jlabels;
    }
    
    /**
     * @return JLabel clicks
     */
    public JLabel getClicks(){
        return clicks;
    }    

    public static InfoPanel getInstance() {
        if (instance != null) {            
            return instance;
        }
        instance = new InfoPanel();
        return instance;
    }
    
    
}
