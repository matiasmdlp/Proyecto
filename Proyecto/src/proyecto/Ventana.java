package proyecto;

import java.awt.*;
import javax.swing.*;

public class Ventana extends JFrame{
    public Ventana(){
        super();
        this.setLayout(new BorderLayout());
        this.setTitle("Lanzamiento de misil");
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1200, 800);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        
    }
}
