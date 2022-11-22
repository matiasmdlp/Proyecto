package GUI;

import java.awt.Font;
import javax.swing.event.*;
import javax.swing.JSlider;
import proyecto.Ventana;

public class VelSlider{
    JSlider velocidad;

    public VelSlider(Ventana v) {
        velocidad = new JSlider(JSlider.HORIZONTAL, 0, 10, 1);
        velocidad.setBounds(500, 710, 250, 100);
        
        velocidad.setMajorTickSpacing(10);
        velocidad.setMinorTickSpacing(1);
        
        velocidad.setPaintTicks(true);
        
        velocidad.setFont(new Font("Serif", Font.ITALIC, 12));
        
        velocidad.setPaintLabels(true);
        velocidad.addChangeListener((ChangeEvent evt) -> {
            BotonvelocidadActionPerformed(evt);
        });
        
        v.add(velocidad);
    }

    private void BotonvelocidadActionPerformed(ChangeEvent evt) {
        System.out.println("Velocidad: " + this.velocidad.getValue());
    }
}
        