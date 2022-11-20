package Items;

import java.awt.Image;
import java.awt.*;
import javax.swing.*;


public class Avion extends JPanel{
    private Image avion;
    private int x, y;
    private int vel=10;
    boolean dir=true;
    
    
    public Avion(){
        loadImage();
        setInitPos();
        
        this.setOpaque(false);
    }
    
    
    private void loadImage() {
        if(dir==false){
            avion = new ImageIcon("Imagenes/AvionL.png").getImage();
            
        }else{
            avion = new ImageIcon("Imagenes/AvionR.png").getImage();
        }
    }
    
    public void CambiarX(int x1){
        x=x1;    
    }
    
    public void CambiarY(int y1){
        y=y1;    
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
    
    private void setInitPos(){
        if(dir==true){
            x=0;
            y=100;
        }else{
            x=1080;
            y=100;
        }
    }
    
    public void mover(){
        if(dir==true){
            x = x+vel;
            if(x>=1200){
                x = -100;
            }
        }
        if(dir==false){
            x = x-vel;
            if(x<=-100){
                x=1200;
            }   
        }
        super.repaint();
    }
    
    public void setVel(int v){
        vel=v;
    }
    public int getVel(){
        return vel;
    }

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(avion, 0, 0, null);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}
