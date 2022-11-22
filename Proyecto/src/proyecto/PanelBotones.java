package proyecto;

import GUI.Botones;
import java.awt.Color;
import javax.swing.JPanel;

public class PanelBotones extends JPanel{
    public PanelBotones(Ventana v){
        super();
        new Botones(v);
        
    }
    
}
