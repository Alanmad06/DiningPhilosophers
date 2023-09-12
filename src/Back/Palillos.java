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
    private final boolean[] Palillos= new boolean[5];
    private ArrayList<Integer> Waiting = new ArrayList<>();
    ImageIcon iconWaiting = new ImageIcon(getClass().getResource("/images/waiting.gif"));
    ImageIcon iconFilosofo = new ImageIcon(getClass().getResource("../images/filosofo1.png"));
    ImageIcon iconPalillo = new ImageIcon(getClass().getResource("../images/palo.png"));
    ImageIcon iconPalilloColor = new ImageIcon(getClass().getResource("../images/palo_color.png"));
    public boolean[] getPalillos() {
        return Palillos;
    }

    public ArrayList<Integer> getWaiting() {
        return Waiting;
    }

    public void setWaiting(int Thinkers) {
        this.Waiting.add(Thinkers);
        
    }
    
 
    
    
    
    public synchronized void consumiendo(int pal1,int pal2, int filosofo , JLabel Filosofo ,JLabel Palillo1,JLabel Palillo2){
        
        while(this.Palillos[pal1] || this.Palillos[pal2] ){
            
            waiting(filosofo,Filosofo);
           
        } 
         System.out.println("Entro consumiendo Filosofo" +filosofo);
        

        System.out.println("Filosofo "+filosofo +"Tomo el palillo "+pal1);
        System.out.println("Filosofo "+filosofo +"Tomo el palillo "+pal2);
        
        changeUsePalillo(pal1,Palillo1);
        changeUsePalillo(pal2,Palillo2);
        
       
       
        
        
    }
    
    public synchronized void dejarPalillos(int pal1,int pal2,int filosofo,JLabel Label,JLabel Palillo1,JLabel Palillo2){
          Label.setIcon(iconFilosofo);
         changeUsePalillo(pal1,Palillo1);
        changeUsePalillo(pal2,Palillo2);
        System.out.println("Dejo de comer Filosofo :"+filosofo);
        notifyAllProcess();
        
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
    
    
    
    
    public void changeUsePalillo(int i,JLabel Palillo){
        if(this.Palillos[i]){
            Palillo.setIcon(iconPalillo);
            this.Palillos[i]=false;
        }else{
            Palillo.setIcon(iconPalilloColor);
            this.Palillos[i]=true;
        }
        
    }
    
    public void clearThinkers(){
        this.Waiting.clear();
    }

    
  
    
 
}
