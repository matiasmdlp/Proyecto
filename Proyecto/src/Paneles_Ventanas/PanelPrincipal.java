package Paneles_Ventanas;

import Items.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;
/**
 * Clase PanelPrincipal: Panel donde se muestran los objetos de la simulacion.
 * @author Joaquin Avalos
 * @author Matias Medina
 * @version 1.0.0
 */

public class PanelPrincipal extends JPanel implements ActionListener{
    public Timer timer;
    Fondo p;
    Avion avion;
    Misil misil;
    public Objetivo car;
    public boolean lanzamiento = false;
    public boolean inicializado=false;
    /**
     * Metodo constructor de PanelPrincipal
     */
    public PanelPrincipal(){
        super();
        setItems();
        
        this.add(p);
        
        if(timer.isRunning()==true){
            Init();
        }
        /*car.ValoresRandom();*/
    }
    
    /**
     * Metodo setter de los objetos utilizados en la simulacion.
     */
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
    /**
     * Metodo que pinta los objetos de la simulacion en el Panel.
     */
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
    /**
     * Metodo que permite situar y movilizar los objetos de la simulacion dado un evento.
     * @param e Evento
     */
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
    /**
     * Metodo que inicia el timer de la simulacion.
     */
    public void Init(){
        timer.start();
        inicializado=true;
    }
    /**
     * Metodo getter que devuelve el estado de la simulacion
     * inicializado true o false
     * @return inicializado
     */
    public boolean Inicializado(){
        return  inicializado;
    }
    /**
     * Metodo que pausa el timer de la simulacion.
     */
    public void Initreset(){
        timer.stop();
        inicializado=false;
    }
    /**
     * Metodo que reinicia la simulacion.
     */
    public void Reset(){
        timer.restart();
        timer.stop();
        avion.Reset();
        misil.Reset();
        car.Reset();
    }
    /**
     * Metodo getter de avion
     * @return  avion
     */
    public Avion getAvion(){
        return avion;
    }
    /**
     * Metodo getter de misil
     * @return misil
     */
    public Misil getMisil(){
        return misil;
    }
    /**
     * Metodo getter de objetivo
     * @return car
     */
    public Objetivo getObj(){
        return car;
    }
}

