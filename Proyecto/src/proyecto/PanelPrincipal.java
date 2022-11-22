package proyecto;

import Items.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PanelPrincipal extends JPanel implements ActionListener{
    private Timer timer, timer2;
    Fondo p;
    Avion avion;
    Misil misil;
    Objetivo car;
    public boolean lanzamiento = false;
    
    public PanelPrincipal(){
        super();
        setItems();
        
        this.add(p);
    }
    
    
    private void setItems(){
        avion = new Avion();
        avion.setBounds(avion.getPosX(), avion.getPosY(), 100, 50);
        this.add(avion);
        
        misil = new Misil(true, avion);
        misil.setBounds(misil.getPosX(), misil.getPosY(), 50, 50);
        this.add(misil);
        
        car = new Objetivo();
        car.setBounds(car.getPosX(), car.getPosY(), 100, 50);
        this.add(car);
        
        p = new Fondo();
        p.setBounds(0, 0, 1200, 650);
        
        timer = new Timer(30,null); 
        timer.addActionListener((ActionListener) this);
        timer.start();
        timer2 = new Timer(100,null);
        timer2.addActionListener((ActionListener) this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        /*System.out.println("*");*/ 
        avion.setBounds(avion.getPosX(), avion.getPosY(), 100, 50);
        avion.mover();
        if(lanzamiento==false){
            misil.setBounds(misil.getPosX(), misil.getPosY(), 50, 50);
            misil.mover();
        }
        p.repaint();
        
        car.setBounds(car.getPosX(), car.getPosY(), 100, 50);
        car.mover();
        
        avion.repaint();
        misil.repaint();
        car.repaint();
   }
}

