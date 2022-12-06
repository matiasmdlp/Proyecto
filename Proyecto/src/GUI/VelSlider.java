package GUI;

import java.awt.Font;
import javax.swing.event.*;
import javax.swing.JSlider;
import proyecto.Ventana;
/**
 * Clase VelSlider, que inicializa y maneja los parametros del slider de velocidad.
 * @author Joaquin Avalos
 * @author Matias Medina
 * @version 1.0.0
 */

public class VelSlider{
    JSlider velocidad;
    Botones botones;
    /**
     * Metodo constructor de VelSlider parametrizado
     * @param v Ventana
     * @param bot Botones
     */

    public VelSlider(Ventana v, Botones bot) {
        botones = bot;
        
        velocidad = new JSlider(JSlider.HORIZONTAL, 0, 15, 1);
        velocidad.setBounds(500, 760, 250, 100); //y=710
        
        velocidad.setMajorTickSpacing(15);
        velocidad.setMinorTickSpacing(1);
        
        velocidad.setPaintTicks(true);
        
        velocidad.setFont(new Font("Serif", Font.ITALIC, 12));
        
        velocidad.setPaintLabels(true);
        velocidad.addChangeListener((ChangeEvent evt) -> {
            BotonvelocidadActionPerformed(evt);
        });
        
        v.add(velocidad);
    }
    /**
     * Metodo que permite modificar el slider de velocidad
     * @param evt 
     */
    private void BotonvelocidadActionPerformed(ChangeEvent evt) {
        botones.selec.setVelocidad(this.velocidad.getValue());
        System.out.println("Velocidad: " + this.velocidad.getValue());
    }
    
}
        