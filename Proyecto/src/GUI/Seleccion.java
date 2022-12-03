package GUI;

import Items.*;
import proyecto.PanelPrincipal;

public class Seleccion {
    private Avion avion;
    private Objetivo objetivo;
    private Misil misil;
    private int cual;
    PanelPrincipal pp;
    
    public Seleccion(Avion a, Objetivo o, Misil m, PanelPrincipal pp){
        this.pp = pp;
        avion = a;
        objetivo = o;
        misil = m;
    }
    
    public void setCual(int x){
        cual =x;
    }
    
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
    
    public void Subir(){
        if(cual==1 && pp.Inicializado()==false){
            avion.CambiarY(-10);
            misil.CambiarY(-10);
            
        }
    }
    
    public void Bajar(){
        if(cual==1 && pp.Inicializado()==false){
            avion.CambiarY(10);
            misil.CambiarY(10);
            
        }
    }
    
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
