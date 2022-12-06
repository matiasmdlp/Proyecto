package GUI;

import Items.*;
import proyecto.PanelPrincipal;
/**
 * Clase Seleccion, permite seleccionar el objetivo a controlar por los botones.
 * @author Joaquin Avalos
 * @author Matias Medina
 * @version 1.0.0
 */

public class Seleccion {
    private Avion avion;
    private Objetivo objetivo;
    private Misil misil;
    private int cual;
    PanelPrincipal pp;
    /**
     * Metodo contructor de Seleccion parametrizado
     * @param a Avion de la simulacion.
     * @param o Objetivo de la simulacion.
     * @param m Misil de la simulacion.
     * @param pp Panel Principal
     */
    
    public Seleccion(Avion a, Objetivo o, Misil m, PanelPrincipal pp){
        this.pp = pp;
        avion = a;
        objetivo = o;
        misil = m;
    }
    //setter
    public void setCual(int x){
        cual = x;
    }
    /**
     * Metodo vacio que controla la direccion hacia la derecha del objeto seleccionado.
     */
    public void Derecha(){
        if(cual==0 && objetivo.getAngulo()==180){
            if(pp.Inicializado()==false){
                objetivo.setAngulo(0); 
                objetivo.setInitPos();
            }else{
                objetivo.setAngulo(0);
            }
        }else if(cual==1){
            if(pp.Inicializado()==false){
                avion.setDireccion(0);
                misil.setDireccion(0);
                avion.setInitPos();
                misil.setInitPos();
            }
        }  
    }
    /**
     * Metodo vacio que controla la direccion hacia la izquierda del objeto seleccionado.
     */
    public void Izquierda(){
        if(cual==0 && objetivo.getAngulo()==0){
            if(pp.Inicializado()==false){
                objetivo.setAngulo(180); 
                objetivo.setInitPos();
            }else{
                objetivo.setAngulo(180);
            }
        }else if(cual==1){
            if(pp.Inicializado()==false){
                avion.setDireccion(180);
                misil.setDireccion(180);
                avion.setInitPos();
                misil.setInitPos();
            }
        }  
    }
    /**
    * Metodo vacio que controla la direccion hacia la arriba del objeto seleccionado.
    */    
    public void Subir(){
        if(cual==1 && pp.Inicializado()==false){
            avion.CambiarY(-10);
            misil.CambiarY(-10);
            
        }
    }
    /**
     * Metodo vacio que controla la direccion hacia la abajo del objeto seleccionado.
     */
    public void Bajar(){
        if(cual==1 && pp.Inicializado()==false){
            avion.CambiarY(10);
            misil.CambiarY(10);
            
        }
    }
    /**
    * Metodo vacio que controla la velocidad del objeto seleccionado.
    */   
    public void setVelocidad(int vel){
        if(cual==0){
            if(pp.Inicializado()==false){
                objetivo.setVelocidad((float)vel);
            }
        }else{
            if(pp.Inicializado()==false){
                avion.setVelocidad((float)vel);
                misil.setVelocidad((float)vel);
            }
        } 
    }
    
    
}
