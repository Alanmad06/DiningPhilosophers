/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back;

import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author alanm
 */
public class Filosofo implements Runnable{
    Random rand = new Random();
    private Palillos palillos ;
    int id;
    int palillo1,palillo2;
    JLabel Filosofo;
    JLabel Palillos[];
    ImageIcon iconThinking = new ImageIcon(getClass().getResource("../images/thinking.gif"));
    ImageIcon iconFilosofo = new ImageIcon(getClass().getResource("../images/filosofo1.png"));
    ImageIcon iconEating = new ImageIcon(getClass().getResource("../images/dumplin1.gif"));
    
    
    public Filosofo(Palillos palillos, int id , JLabel Label, JLabel[] Palillos) {
        
        this.palillos = palillos;
        this.id = id;
        this.Filosofo=Label;
        this.Palillos=Palillos;
        calcularPalillos();
        
        
    }
    
    

    @Override
    public void run() {
        while(true){
             Filosofo.setIcon(iconFilosofo);
            thinking();
            this.palillos.consumiendo(palillo1, palillo2, id ,Filosofo,Palillos[palillo1],Palillos[palillo2]);
            eating();
            this.palillos.dejarPalillos(palillo1,palillo2, id ,Filosofo,Palillos[palillo1],Palillos[palillo2]);
        }
        
        
    }
    
    public void calcularPalillos(){
        
        for ( int i = 0 ; i<=this.palillos.getPalillos().length;i++){
            if(i == 0 && i == id){
                this.palillo1 = this.palillos.getPalillos().length-1;
                this.palillo2 = 0;
            }else if(i==id){
                this.palillo1 = i-1;
                this.palillo2 = i;
            }
           
        }
               
    }
    
    public void thinking(){
        System.out.println("Pensando Filosofo "+id);
        try {
             int numeroAleatorio = rand.nextInt(4001) + 6000;
             System.out.println("Pensando por "+numeroAleatorio+" Filosofo "+id);
             Filosofo.setIcon(iconThinking);
        
            sleep(numeroAleatorio);
        } catch (InterruptedException ex) {
            Logger.getLogger(Filosofo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eating(){
        System.out.println("Pensando Comiendo "+id);
        try {
             int numeroAleatorio = rand.nextInt(2001) + 3000;
             System.out.println("Comiendo por "+numeroAleatorio+" Filosofo "+id);
         Filosofo.setIcon(iconEating);
            sleep(numeroAleatorio);
        } catch (InterruptedException ex) {
            Logger.getLogger(Filosofo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
}
