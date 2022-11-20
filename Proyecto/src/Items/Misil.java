package Items;

import java.awt.*;
import javax.swing.*;

public class Misil extends JPanel{
    private Image misil;
    private boolean v;
    private int x, y;
    private int vel=0;
    boolean dir=true;
    Avion av;
    
    public Misil(boolean v, Avion av){
        this.v = v;
        this.av=av;
        vel=av.getVel();
        
        loadImage();
        setInitPos();
        
        this.setOpaque(false);
    }
        
    private void loadImage() {
        if(dir==false){
            misil = new ImageIcon("Imagenes/MisilL.png").getImage();
            
        }else{
            misil = new ImageIcon("Imagenes/MisilR.png").getImage();
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
            x=av.getPosX()+40;
            y=av.getPosY()+25;
        }else{
            x=av.getPosX()+10;
            y=av.getPosY()+25;
        }
    } 
    
    public void mover(){
        if(dir==true){
            x = x+vel;
            if(x>=1240){
                x = -60;
            }
        }
        if(dir==false){
            x = x-vel;
            if(x<=-90){
                x=1210;
            }   
        }
        super.repaint();
    }
    
    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(misil, 0, 0, null);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}
