package proyecto;

import GUI.*;
import java.awt.Color;
import javax.swing.JPanel;

public class PanelBotones extends JPanel{
    VelSlider vel;
    
    public PanelBotones(Ventana v){
        super();
<<<<<<< Updated upstream
        //new Botones(v);
        new PanelBotonesss();
=======
<<<<<<< HEAD
        //new Botones(v);
        new PanelBotonesss();
=======
        new Botones(v); 
>>>>>>> 731c9bde6038d815491fd0025f39a42ecf653a20
>>>>>>> Stashed changes
        
        vel = new VelSlider(v);
    }
    
}
