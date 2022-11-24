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
        if(cual==0){
            if(pp.Inicializado()==false){
                objetivo.setDireccion(true);
                objetivo.setInitPos();
            }else{
                objetivo.setDireccion(true);
            }
        }else if(cual==1){
            if(pp.Inicializado()==false){
                avion.setDireccion(true);
                misil.setDireccion(true);
                avion.setInitPos();
                misil.setInitPos();
            }
        }  
    }
    
    public void Izquierda(){
        if(cual==0){
            if(pp.Inicializado()==false){
                objetivo.setDireccion(false);
                objetivo.setInitPos();
            }else{
                objetivo.setDireccion(false);
            }
        }else if(cual==1){
            if(pp.Inicializado()==false){
                avion.setDireccion(false);
                misil.setDireccion(false);
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
                if(objetivo.CualDireccion()==true){
                    objetivo.setVel(vel);
                }else{
                    objetivo.setVel(-vel);
                }
            }
        }else{
            if(pp.Inicializado()==false){
                if(objetivo.CualDireccion()==true){
                    avion.setVel(vel);
                    misil.setVel(vel);
                }else{
                    avion.setVel(-vel);
                    misil.setVel(-vel);
                }
                
            }
        } 
    }
    
    
}
