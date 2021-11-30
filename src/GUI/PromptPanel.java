package GUI;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import javax.swing.*;

/**
 * afti i klasi ftiaxnei to proto menu pou anoigei otan ektelesti to programma
 * o xristis dinei onoma kai epipedo diskolias
 */
public final class PromptPanel extends JFrame{
    
    private static PromptPanel instance;
    static JButton button; 
    static JLabel text,text1,n,t,c;
    static JTextField textfield;
    static JComboBox box;
    String namenow,name; 
    String getmode="Easy";
    int time,clicks;
    private final String[] mode = {"Easy","Medium","Hard"};
    private final String[] values = new String[2];
    
    public PromptPanel() throws SQLException{
        super("Card Memory Game");
        this.makePrompt();
    }
    
    public void makePrompt() throws SQLException{
        
        JPanel p = new JPanel();
        JComboBox<String> box = new JComboBox<>(mode);
        text = new JLabel("");
        text1 = new JLabel("Enter Your Name: ");         
        button = new JButton("Enter Game"); 
        textfield = new JTextField(16);
        //this.addListener();        
        
        box.addItemListener(new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if(e.getStateChange() == ItemEvent.SELECTED) {
                getmode = box.getSelectedItem().toString();
            }
        }
    });
        
        p.add(text1);
        p.add(textfield);
        p.add(box);
        p.add(button); 
        p.add(text);
        p.setBackground(Color.cyan);
        
        this.add(p); 
        this.setSize(300, 150); 
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);       
    
    }
    
    /**
     * otan patithei to Enter game blepei an iparxei onoma kai arxizei to paixnidi
     * epistrefei to mode kai to onoma se ena pinaka JLabel[]
     */
    public String[] addListener() {
        button.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            name = textfield.getText();
           if(name.equals("")){
               text.setText("             Please Enter Your Name             ");
           }
        }
  
    });
        
        values[0]=name;
        values[1]=getmode;
        return values;
    }

    /**
     * singleton
     */
    public static PromptPanel getInstance() throws SQLException{
        if (instance != null) {            
            return instance;
        }

        instance = new PromptPanel();
        return instance;
    } 
    
    
}
