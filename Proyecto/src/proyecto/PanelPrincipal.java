package proyecto;

import Items.*;
import Metodos.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PanelPrincipal extends JPanel implements ActionListener{
    public Timer timer;
    Fondo p;
    Avion avion;
    public Misil misil;
    public Objetivo car;
    public boolean lanzamiento = false;
    public boolean inicializado=false;
    DetectarColision dC = new DetectarColision(this);
    PerseguirObjetivo po = new PerseguirObjetivo(this);
    public int colision;
    
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
        
        
        misil = new Misil(avion);
        misil.setBounds(misil.getPosX(), misil.getPosY(), 50, 50);
        this.add(misil);
        
        car = new Objetivo();
        car.setBounds(car.getPosX(), car.getPosY(), 100, 50);
        this.add(car);
        
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


        
        p.repaint();


        
        colision = dC.checkCollision(this);
 
        if (colision == 0) {
            misil.setBounds(misil.getPosX(), misil.getPosY(), 50, 50);
            misil.solidArea.setBounds(misil.getPosX(), misil.getPosY(), misil.solidArea.width, misil.solidArea.height);
            misil.persecutionArea.setBounds(misil.getPosX(), misil.getPosY(), misil.persecutionArea.width, misil.persecutionArea.height);
            misil.mover();

            car.setBounds(car.getPosX(), car.getPosY(), 100, 50);
            car.solidArea.setBounds(car.getPosX(), car.getPosY(), car.solidArea.width, car.solidArea.height);
            car.mover();
        }
        if (colision == 1) {
            misil.setBounds(misil.getPosX(), misil.getPosY(), 50, 50);
            misil.solidArea.setBounds(misil.getPosX(), misil.getPosY(), misil.solidArea.width, misil.solidArea.height);
            misil.persecutionArea.setBounds(misil.getPosX(), misil.getPosY(), misil.persecutionArea.width, misil.persecutionArea.height);
            po.getDirection();
            car.setBounds(car.getPosX(), car.getPosY(), 100, 50);
            car.solidArea.setBounds(car.getPosX(), car.getPosY(), car.solidArea.width, car.solidArea.height);
            car.mover();
        } if(colision == 2) {
            //colision == 2, misil queda "pegado a car" 
            misil.setBounds(car.getPosX(), car.getPosY(), 50, 50);
            misil.solidArea.setBounds(car.getPosX(), car.getPosY(), misil.solidArea.width, misil.solidArea.height);
            misil.persecutionArea.setBounds(car.getPosX(), car.getPosY(), misil.persecutionArea.width, misil.persecutionArea.height);
            car.setBounds(car.getPosX(), car.getPosY(), 100, 50);
            car.solidArea.setBounds(car.getPosX(), car.getPosY(), car.solidArea.width, car.solidArea.height);
            car.mover();
        }

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

