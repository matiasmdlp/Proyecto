package proyecto;

import Items.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PanelPrincipal extends JPanel implements ActionListener{
    public Timer timer;
    Fondo p;
    Avion avion;
    Misil misil;
    public Objetivo car;
    public boolean lanzamiento = false;
    public boolean inicializado=false;
    
    public PanelPrincipal(){
        super();
        setItems();
        
        this.add(p);
        
        if(timer.isRunning()==true){
            Init();
        }
    }
    
    
    private void setItems(){
        avion = new Avion();
        avion.setBounds(avion.getPosX(), avion.getPosY(), 100, 50);
        this.add(avion);
        
        car = new Objetivo();
        car.setBounds(car.getPosX(), car.getPosY(), 100, 50);
        this.add(car);
        
        misil = new Misil(avion, car);
        misil.setBounds(misil.getPosX(), misil.getPosY(), 50, 50);
        this.add(misil);
        
        
        p = new Fondo();
        p.setBounds(0, 0, 1200, 650);
        
        timer = new Timer(30,null); 
        timer.addActionListener((ActionListener) this);
    }
    
    public void print(){
        avion.setBounds(avion.getPosX(), avion.getPosY(), 100, 50);
        misil.setBounds(misil.getPosX(), misil.getPosY(), 50, 50);
        car.setBounds(car.getPosX(), car.getPosY(), 100, 50);
        
        p.repaint();
        avion.repaint();
        misil.repaint();
        car.repaint();
        super.repaint();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        /*System.out.println("*");*/ 
        avion.setBounds(avion.getPosX(), avion.getPosY(), 100, 50);
        avion.mover();
        
        if(misil.colision2==false){
            car.setBounds(car.getPosX(), car.getPosY(), 100, 50);
            car.mover();
            misil.setBounds(misil.getPosX(), misil.getPosY(), 50, 50);
        }else{
            misil.setBounds(misil.getPosX()-150, misil.getPosY()-200, 250, 250);
        }
        
        misil.Deteccion();
        misil.NoDeteccion();
        misil.ColisionCar();
        
        if(misil.detected==false && misil.colision2==false){
            misil.mover();
        }
        if(misil.detected==true && misil.colision2==false){
            misil.mover2();
        }
        
        p.repaint();
        
        super.repaint();
        avion.repaint();
        misil.repaint();
        car.repaint();
   }
    
    public void Init(){
        inicializado=true;
    }
    public boolean Inicializado(){
        return  inicializado;
    }
    public void Initreset(){
        inicializado=false;
    }
    public Avion getAvion(){
        return avion;
    }
    public Misil getMisil(){
        return misil;
    }
    public Objetivo getObj(){
        return car;
    }
}

