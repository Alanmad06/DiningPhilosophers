/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author alanm
 */
public class Palillos {
    Random rand = new Random();
    Object[] Palillos = new Object[5];
    private ArrayList<Integer> Waiting = new ArrayList<>();
    ImageIcon iconWaiting = new ImageIcon(getClass().getResource("/images/waiting.gif"));
    ImageIcon iconFilosofo = new ImageIcon(getClass().getResource("../images/filosofo1.png"));
    ImageIcon iconPalillo = new ImageIcon(getClass().getResource("../images/palo.png"));
    ImageIcon iconPalilloColor = new ImageIcon(getClass().getResource("../images/palo_color.png"));
    ImageIcon iconPalilloColor1 = new ImageIcon(getClass().getResource("../images/palo_color1.png"));
    ImageIcon iconPalilloColor2 = new ImageIcon(getClass().getResource("../images/palo_color2.png"));
    ImageIcon iconPalilloColor3 = new ImageIcon(getClass().getResource("../images/palo_color3.png"));
    ImageIcon iconPalilloColor4 = new ImageIcon(getClass().getResource("../images/palo_color4.png"));
    ImageIcon iconEating = new ImageIcon(getClass().getResource("../images/dumplin1.gif"));
     
     
    public Object[] getPalillos() {
        return Palillos;
    }

    public ArrayList<Integer> getWaiting() {
        return Waiting;
    }

    public void setWaiting(int Thinkers) {
        this.Waiting.add(Thinkers);
        
    }
    public Palillos(){
        for (int i = 0; i <Palillos.length;i++){
            Palillos[i]= new Object();
        }
    }
 
    
    
    
    public  void consumiendo(int pal1,int pal2, int filosofo , JLabel Filosofo ,JLabel Palillo1,JLabel Palillo2){
       
        
        synchronized(Palillos[pal1]){
            System.out.println("Filosofo" +filosofo+" Tomo el Palillo "+pal1);
            checkColorPalillo1(filosofo,Palillo1);
            synchronized(Palillos[pal2]){
                 checkColorPalillo2(filosofo,Palillo2);
                 System.out.println("Filosofo" +filosofo+" Tomo el Palillo "+pal2);
                 
               eating(filosofo,Filosofo);
                 
                System.out.println("Filosofo" +filosofo+" Dejo el Palillo "+pal2);  
                Palillo2.setIcon(iconPalillo);
            }
           
             System.out.println("Filosofo" +filosofo+" Dejo el Palillo "+pal1); 
             Palillo1.setIcon(iconPalillo);
             Filosofo.setIcon(iconFilosofo);
        }
        
        
      
    }
    public void checkColorPalillo1(int filosofo,JLabel pal1){
        
        switch(filosofo){
            case 0: 
                pal1.setIcon(iconPalilloColor);
                
                break;
            case 1: 
                pal1.setIcon(iconPalilloColor1);
             
                break;
             case 2: 
                pal1.setIcon(iconPalilloColor2);
               
                break;
                 case 3: 
                pal1.setIcon(iconPalilloColor3);
               
                break;
               case 4: 
                pal1.setIcon(iconPalilloColor4);
             
                break;
        }        
    }
    
    public void checkColorPalillo2(int filosofo, JLabel pal2){
        switch(filosofo){
            case 0: 
                
                pal2.setIcon(iconPalilloColor);
                break;
            case 1: 
              
                pal2.setIcon(iconPalilloColor1);
                break;
             case 2: 
                
                pal2.setIcon(iconPalilloColor2);
                break;
                 case 3: 
                
                pal2.setIcon(iconPalilloColor3);
                break;
               case 4: 
                
                pal2.setIcon(iconPalilloColor4);
                break;
        }        
    }
 
    
     public void eating(int filosofo,JLabel Filosofo){
        
        try {
             long numeroAleatorio = (long) (Math.random() * 4000);
             System.out.println("Comiendo por "+numeroAleatorio+" Filosofo "+filosofo);
         Filosofo.setIcon(iconEating);
            sleep(numeroAleatorio);
        } catch (InterruptedException ex) {
            Logger.getLogger(Filosofo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public void notifyAllProcess(){
        System.out.println("Notificando All....");
        notifyAll();
        clearThinkers();
    }
    
    
    
    public void waiting(int filosofo,JLabel Label){
        try {
            System.out.println("Waiting Filosofo "+filosofo);
            setWaiting(filosofo);
            Label.setIcon(iconWaiting);
            wait();
        } catch (InterruptedException ex) {
            Logger.getLogger(Palillos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    

    
    public void clearThinkers(){
        this.Waiting.clear();
    }

    
  
    
 
}
