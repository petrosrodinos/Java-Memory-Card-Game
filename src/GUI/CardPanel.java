package GUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

//afti i klasi ftiaxnei to panel me tis kartes 

public class CardPanel extends JPanel{

    private static CardPanel instance;
    JLabel jl;
    JLabel[] matches;
    private JButton buttons[];
    Random rand = new Random();
    int random,posaicons,poseskartes,x,y,counter1,counter2=0;
    public InfoPanel info;
    String[] randomicons = new String[18];
    int[] exist = new int[36];
    int[] iconexist = new int[18];
    private final String[] icons = {"apple.png","bananas.png","orange.png","berry.png","grapes.png","mango.png",
    "pineapple.png","strawberry.png","watermelon.png","tomato.png","lemon.png","avocado.png","pomegranate.png","durian.png",
    "eggplant.png","carrot.png","cabbage.png","broccoli.png","bell-pepper.png"};
   
    public  CardPanel(){
        
    }   
    
    //basi tou epipedou diskolias pou ekxorithike ftiaxnoume to layout mas
    void initComponets(String mode){        
        if(mode.equalsIgnoreCase("easy")){
            poseskartes = 12;
            posaicons = 6;
            x=3;
            y=4;
        }else if(mode.equalsIgnoreCase("medium")){
            poseskartes = 20;
            posaicons = 10;
            x=4;
            y=5;
        }else if(mode.equalsIgnoreCase("hard")){
            poseskartes = 36;
            posaicons = 18;
            x=6;
            y=6;             
        }
        buttons = new JButton[poseskartes];
        this.setLayout(new GridLayout(x,y));
        this.setPreferredSize(new Dimension(500, 500));
        
        for(int i=0; i<poseskartes; i++){
            this.add(buttons[i] = new JButton());
            buttons[i].setBackground(Color.black);
            buttons[i].setIcon(new ImageIcon("src/Icons/back.png"));
            buttons[i].setBorder(BorderFactory.createLineBorder(Color.black, 2));
        }
        
        //klasi gia na ginoun ta events ton koumpion
        Events ev = new Events();
        ev.setButtons(buttons);
        ev.setClicksLabel(jl);
        ev.setMatchesLabel(matches);
        ev.setMode(posaicons);
        ev.addListeners();
        setRandomIcons();           
            
    }
    
   //sinartisi pou dinei se kathe button tis diades tixaion eikonidion
    public void setRandomIcons(){
        //gemizei ena pinaka me tuxaia eikonidia poy den epanalambanontai
        for(int i=0;i<posaicons;i++){
            random = rand.nextInt(19);
            while(iconExist(random)){
                random = rand.nextInt(19);
            }            
        }
        
        for(int i=0;i<posaicons;i++){
            randomicons[i] = icons[iconexist[i]];
            //System.out.println(randomicons[i]);
        }
        
        //gemizei ena pinaka me tuxaies thesis poy den epanalambanontai
        for(int i=0;i<poseskartes;i++){
            random = rand.nextInt(poseskartes);
            while(ifexist(random)){
                random = rand.nextInt(poseskartes);
                if(i==poseskartes){
                    break;
                }
            }
        }
        
        
        //dinei onoma sto kathe koympi me basei to tixaio eikonidio oste na to parei i klasi
        //Events kai na tous dosei to eikonidio
        for(int i=0;i<poseskartes;i++){
            if(i<poseskartes/2){
                buttons[exist[i]].setName(randomicons[i]);
                System.out.println(exist[i]+" : "+randomicons[i]);
            }else if(i>=poseskartes/2){
                buttons[exist[i]].setName(randomicons[i-(poseskartes/2)]);
                System.out.println(exist[i]+" : "+randomicons[i-(poseskartes/2)]);
            }
           
        }
        System.out.println("<==============>");
            
        
 }
    //gemizei ena pinaka me  tuxaia eikonidia poy den epanalambanontai
    public boolean iconExist(int value){        
       for(int i=0;i<posaicons;i++){
           if(iconexist[i]==value){
               return true;
           }
        }
        iconexist[counter2++]=value;
        //System.out.println(iconexist[counter2-1]+"");
        return false;
       
   }
    
    //gemizei ena pinaka me tuxaies thesis poy den epanalambanontai
    public boolean ifexist(int value){
        for(int i=0;i<poseskartes-1;i++){
           if(exist[i]==value){
               return true;
           }
        }
       exist[counter1++]=value;
       //System.out.println(exist[counter1-1]+"");
       return false;
    } 
    
    public void getText(JLabel jl){
        this.jl = jl;
        
    }
    
    public void getMatches(JLabel[] matches){
        this.matches = matches;
    }
    
    public static CardPanel getInstance(){
        if (instance != null) {            
            return instance;
        }
        instance = new CardPanel();
        return instance;
    }

    
}
