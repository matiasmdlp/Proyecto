
package Metodos;

import GUI.*;
import Items.*;
import proyecto.*;

public class DetectarColision {
    private Misil misil;
    private Objetivo objetivo;
    
    public boolean colision;
    
    PanelPrincipal pp;
    
    public DetectarColision(PanelPrincipal pp){
        this.colision = false;
        this.pp = pp;
    }
    
    public boolean checkCollision(PanelPrincipal pp){
        if(pp.misil.solidArea.intersects(pp.car.solidArea)){
            System.out.println("COLISION!!");
            return colision = true;
        }
        else{
            return colision;
        }
    }
    
}
