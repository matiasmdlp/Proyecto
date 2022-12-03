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
        /*car.ValoresRandom();*/
    }
    
    
    private void setItems(){
        avion = new Avion();
        avion.setBounds(0, 0, 100, 50);
        this.add(avion);
        
        car = new Objetivo();
        car.setBounds((int)car.getPosX(), (int)car.getPosY(), 100, 50);
        this.add(car);
        
        misil = new Misil(avion, car);
        misil.setBounds(0, 100, 0, 50);
        this.add(misil);
        
        
        p = new Fondo();
        p.setBounds(0, 0, 1200, 650);
        
        timer = new Timer(30,null); 
        timer.addActionListener((ActionListener) this);
        /*timer.start();*/
    }
    
    public void print(){
        /*car.setBounds(car.getPosX(), car.getPosY(), 100, 50);*/
        /*misil.setBounds(140, 25, 50, 50);
        avion.setBounds(100, 0, 100, 50);*/
        if(inicializado==false){
            car.setBounds((int)car.getPosX(), (int)car.getPosY(), 100, 50);
            avion.setBounds((int)avion.getPosX(), (int)avion.getPosY(), 100, 50);
            misil.setBounds((int)misil.getPosX(), (int)misil.getPosY(), 50, 50);
        }
        
        p.repaint();
        avion.repaint();
        car.repaint();
        misil.repaint();
        super.repaint();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        /*System.out.println("*");*/ 
        misil.Colision();
        
        car.setBounds((int)car.getPosX(), (int)car.getPosY(), 100, 50);
        car.mover();
        avion.setBounds((int)avion.getPosX(), (int)avion.getPosY(), 100, 50);
        avion.mover();
        misil.setBounds((int)misil.getPosX(), (int)misil.getPosY(), 50, 50);
        misil.mover();
        p.repaint();
        
        if(misil.getColision()==true){
            misil.setBounds((int)misil.getPosX()-100, (int)misil.getPosY()-150, 250, 250);
        }
                       
        super.repaint();
        avion.repaint();
        car.repaint();
        misil.repaint();
        
   }
    
    public void Init(){
        timer.start();
        inicializado=true;
    }
    public boolean Inicializado(){
        return  inicializado;
    }
    public void Initreset(){
        timer.stop();
        inicializado=false;
    }
    public void Reset(){
        timer.restart();
        timer.stop();
        avion.Reset();
        misil.Reset();
        car.Reset();
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

