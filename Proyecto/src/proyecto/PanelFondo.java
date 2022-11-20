package proyecto;

import javax.swing.*;
import java.awt.*;

public class PanelFondo extends JPanel{
    private Image fondo;
    
    public PanelFondo(){
        loadImage();
        setSurfaceSize();
        this.setBounds(0, 0, 1200, 650);
    }
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
