
package Metodos;

import GUI.*;
import Items.*;
import proyecto.*;

public class DetectarColision {
    private Misil misil;
    private Objetivo objetivo;
    // colision = 0 (No detecta persecucion, ni lo ha pillado
    // colision = 1 (Detecta zona de persecucion)
    // colision = 2 (lo ha pillado)
    public int colision;
    
    PanelPrincipal pp;
    
    public DetectarColision(PanelPrincipal pp){
        this.colision = 0;
        this.pp = pp;
    }
    
    public int checkCollision(PanelPrincipal pp){
        if(pp.misil.persecutionArea.intersects(pp.car.solidArea) && (pp.misil.solidArea.intersects(pp.car.solidArea) == false)){
            System.out.println("Persiguiendo Objetivo");
            return colision = 1;
        } if(pp.misil.solidArea.intersects(pp.car.solidArea) && pp.misil.persecutionArea.intersects(pp.car.solidArea)){
            System.out.println("Colision");
            return colision = 2;
        }
        else{
            return colision;
        }
    }
    
}
