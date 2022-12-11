package Paneles_Ventanas;

import GUI.*;
import javax.swing.JPanel;
/**
 * Clase PanelBotones: Panel donde se crea el GUI de botones
 * @author Joaquin Avalos
 * @author Matias Medina
 * @version 1.0.0
 * vel: Slider de velocidad
 * botones: botones del GUI
 */
public class PanelBotones extends JPanel{
    VelSlider vel;
    Botones botones;
    /**
     * Crea el Panel de Botones
     * @param v : ventana
     * @param pp : Panel Principal
     */
    public PanelBotones(Ventana v, PanelPrincipal pp){
        super();
        botones = new Botones(v, pp,vel); 
        
        vel = new VelSlider(v, botones);
    }
    
}
