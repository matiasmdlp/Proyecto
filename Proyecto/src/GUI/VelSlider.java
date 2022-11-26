package GUI;

import java.awt.Font;
import javax.swing.event.*;
import javax.swing.JSlider;
import proyecto.Ventana;

public class VelSlider{
    JSlider velocidad;
    Botones botones;

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

    private void BotonvelocidadActionPerformed(ChangeEvent evt) {
        botones.selec.setVelocidad(this.velocidad.getValue());
        System.out.println("Velocidad: " + this.velocidad.getValue());
    }
}
        