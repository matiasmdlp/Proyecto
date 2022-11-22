package proyecto;

import GUI.*;
import java.awt.Color;
import javax.swing.JPanel;

public class PanelBotones extends JPanel{
    VelSlider vel;
    
    public PanelBotones(Ventana v){
        super();
        new Botones(v); 
        
        vel = new VelSlider(v);
    }
    
}
