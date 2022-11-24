package proyecto;

import GUI.*;
import java.awt.Color;
import javax.swing.JPanel;

public class PanelBotones extends JPanel{
    VelSlider vel;
    Botones botones;
    
    public PanelBotones(Ventana v, PanelPrincipal pp){
        super();
        botones = new Botones(v, pp); 
        
        vel = new VelSlider(v, botones);
    }
    
}
