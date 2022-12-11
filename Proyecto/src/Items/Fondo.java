package Items;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 * Clase Fondo, que permite mostrar el fondo de la simulacion.
 * @author Matias Medina
 * @author Joaquin Avalos
 */
public class Fondo extends JPanel{
    /** Image almacenar la imagen asociada al misil*/ 
    private Image fondo;
    
    /** Constructor, se inicializan valores por defecto*/
    public Fondo(){
        loadImage();
        setSurfaceSize();
        this.setBounds(0, 0, 1200, 650);
    }
    
    /** Realiza la carga de imagen */ 
    private void loadImage() {
        fondo = new ImageIcon("Imagenes/fondo.png").getImage();
    }
    /**
     * Metodo setter del fondo de la simulacion
     */
    private void setSurfaceSize() {
        
        Dimension d = new Dimension();
        d.width = fondo.getWidth(null);
        d.height = fondo.getHeight(null);
        setPreferredSize(d);        
    }
    /**
     * Metodo que pinta el fondo de la simulacion.
     * @param g 
     */
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
