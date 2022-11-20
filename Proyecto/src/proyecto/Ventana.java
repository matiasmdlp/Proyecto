package proyecto;

import Items.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Ventana extends JFrame implements ActionListener{
    private Timer timer, timer2;
    PanelFondo p;
    Avion avion;
    Misil misil;
    Objetivo car;
    public boolean lanzamiento = false;
            
    public Ventana(){
        super();
        setItems();
                
        this.setBackground(Color.black);
        this.add(p);
        
        
        this.setLayout(new BorderLayout());
        this.setTitle("Proyecto");
        this.setSize(1200, 900);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
        
        p = new PanelFondo();
        p.setBounds(0, 0, 1200, 650);
        
        timer = new Timer(50,null); 
        timer.addActionListener(this);
        timer.start();
        timer2 = new Timer(100,null);
        timer2.addActionListener(this);
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
