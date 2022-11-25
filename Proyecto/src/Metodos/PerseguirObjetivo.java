
package Metodos;

import static java.lang.Math.*;
import proyecto.*;


public class PerseguirObjetivo {
    PanelPrincipal pp;
    double dx;
    double dy;
    double distancia;
    double vdx;
    double vdy;
    double nx;
    double ny;
    
    public PerseguirObjetivo(PanelPrincipal pp){
        this.pp = pp;
    }
    public void getDirection(){

        dx = (pp.car.getPosX() - pp.misil.getPosX());
        dy = (pp.car.getPosY() - pp.misil.getPosY());
        
        distancia = sqrt(dx * dx + dy * dy);
        
        vdx = dx / distancia;
        vdy = dy / distancia;
        
        nx += vdx;
        ny += vdy;
        
        pp.misil.CambiarX((int) nx);
        pp.misil.CambiarY((int) ny);
        /*if(pp.misil.getPosY() > 590){
            pp.misil.CambiarY(590);
        } else {
            pp.misil.CambiarY((int) ny);
        }
*/
    }
    
    
    
}
