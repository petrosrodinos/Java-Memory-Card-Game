package GUI;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;

//afti i klasi analambanei na balei events sta koumpia kai na ekxorisei ta eikonidia
public final class Events implements ActionListener{
    
    private  JButton buttons[];
    public int countclicks,rounds=0;
    public JLabel clicks;
    public JLabel[] matches;
    public int mode;
    
    public Events(){
        //this.addListeners();       
    
    }


     public void addListeners(){
        Date time = new java.util.Date();
        System.out.println("Time Started");
        ChangeIcon changeicon = new ChangeIcon(matches,mode);
        changeicon.setTimeStart(time.getTime());
        for(JButton button : buttons){
            button.addMouseListener(new MouseListener(){
                @Override
                public void mouseClicked(MouseEvent e) {
                    changeicon.setButton(button);
                    if(++countclicks==2){
                       rounds++;
                       countclicks=0;
                    }
                    clicks.setText("ROUNDS: "+rounds);  

                }

                @Override
                public void mousePressed(MouseEvent e) {
                    button.setBorder(BorderFactory.createLineBorder(Color.white, 3));
                 }

                @Override
                public void mouseReleased(MouseEvent e) { 
                    button.setBorder(BorderFactory.createLineBorder(Color.black, 2));
                }

                @Override
                public void mouseEntered(MouseEvent e) {}

                @Override
                public void mouseExited(MouseEvent e) {}
             });
        }
    }
     
    public void setButtons(JButton[] buttons){
        this.buttons = buttons;
    }
    
    public void setClicksLabel(JLabel clicks){
        this.clicks = clicks;
    }
    
    public void setMatchesLabel(JLabel[] jl){
        this.matches = jl;
    }
    
    public void setMode(int mode){
        this.mode = mode;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}


