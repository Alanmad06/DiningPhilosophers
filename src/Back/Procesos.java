/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back;

import Front.Visual;
import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author alanm
 */
public class Procesos {
    Palillos palillos = new Palillos ();
    private JLabel Label;
    Visual visual ;
    
    public Procesos(Visual visual){
        this.visual = visual;
        
    }
    public ArrayList<Integer> getWaiting(){
        return this.palillos.getWaiting();
    }
    
    public boolean[] getPalillos(){
        return this.palillos.getPalillos();
    }
        
    public void startProcess(JLabel[] Fil,JLabel[] Pal){
        for(int i = 0;i <=palillos.getPalillos().length-1;i++){
        Filosofo fil = new Filosofo(palillos,i,Fil[i],Pal);
        Thread hilo = new Thread(fil);
        hilo.start();
        }
    }
}
