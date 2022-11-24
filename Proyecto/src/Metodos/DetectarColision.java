
package Metodos;

import GUI.*;
import Items.*;
import proyecto.*;

public class DetectarColision {
    private Misil misil;
    private Objetivo objetivo;
    
    PanelPrincipal pp;
    
    public DetectarColision(PanelPrincipal pp){
        this.pp = pp;
    }
    
    public void checkCollision(PanelPrincipal pp){
        if(pp.misil.solidArea.intersects(pp.car.solidArea)){
            System.out.println("COLISION!!");
        }
    }
    
}
