package Items;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Objetivo extends JPanel{
    private Image objetivo;
    private int x;
    static private int y;
    boolean dir=true;
    
    public Objetivo(){
        
        loadImage();
        x=0;
        y=555;
        this.setOpaque(false);
    }
    
    private void loadImage() {
        if(dir==false){
            objetivo = new ImageIcon("Imagenes/AutoL.png").getImage();
            
        }else{
            objetivo = new ImageIcon("Imagenes/AutoR.png").getImage();
        }
    }
    
    public void CambiarX(int x1){
        x=x1;    
    }
    
    public void CambiarY(int y1){    
    }
    
    public int getPosX(){
        return x;
    }
    public int getPosY(){
        return y;
    }
    
    public void setDireccion(boolean b){
        dir=b;
    }
    
    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(objetivo, 0, 0, null);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}

