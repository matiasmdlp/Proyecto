package proyecto;

import java.awt.*;
import javax.swing.*;

public class Ventana extends JFrame{
    private final PanelFondo fondo;
    public Ventana(){
        super();
        this.setLayout(new BorderLayout());
        this.setTitle("Lanzamiento de misil");
        
        fondo = new PanelFondo();
        this.getContentPane().add(fondo);
                       
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1200, 800);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }
}
