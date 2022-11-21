package proyecto;

import javax.swing.*;
import java.awt.*;
import Items.*;

/** 
 * Clase PanelFondo generar un fondo para la animación
 * @author Matias Medina
 * @author Joaquin Avalos 
 * @version versión 1, 19 de noviembre de 2022
 */
public class PanelFondo extends JPanel{
    /** Image almacenar la imagen asociada al misil*/ 
    private Image fondo;
    
    /** Constructor, se inicializan valores por defecto*/
    public PanelFondo(){
        loadImage();
        setSurfaceSize();
        this.setBounds(0, 0, 1200, 650);
    }
    
    /** Realiza la carga de imagen */ 
    private void loadImage() {
        fondo = new ImageIcon("Imagenes/fondo.png").getImage();
    }
    
    private void setSurfaceSize() {
        
        Dimension d = new Dimension();
        d.width = fondo.getWidth(null);
        d.height = fondo.getHeight(null);
        setPreferredSize(d);        
    }

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(fondo, 0, 0, null);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
}
