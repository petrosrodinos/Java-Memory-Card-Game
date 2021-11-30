package GUI;

import java.util.TimerTask;
import javax.swing.JLabel;


    class Time extends TimerTask {
        //afti i klasi dimiourgei ton xrono
        public static int minutes=0;
        public static int seconds=0;
        public  JLabel time;
        
        public Time(JLabel time){
            this.time = time;
            
            }
        
        @Override
       public void run() { 
          seconds++;
          if(seconds==60){
              minutes++;
              seconds=0;
          }
         
          time.setText("TIME: "+minutes+":"+seconds);
           
           
          
       }

       
       
    }
