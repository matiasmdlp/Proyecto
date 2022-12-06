package proyecto;

import GUI.*;
import java.awt.Color;
import javax.swing.JPanel;
/**
 * Clase PanelBotones: Panel donde se crea el GUI de botones
 * @author Joaquin Avalos
 * @author Matias Medina
 * @version 1.0.0
 */
public class PanelBotones extends JPanel{
    VelSlider vel;
    Botones botones;
    
    public PanelBotones(Ventana v, PanelPrincipal pp){
        super();
        botones = new Botones(v, pp,vel); 
        
        vel = new VelSlider(v, botones);
    }
    
}
