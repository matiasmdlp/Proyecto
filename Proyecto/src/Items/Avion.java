package Items;

import java.awt.Image;
import java.awt.*;
import javax.swing.*;

/** 
 * Clase Avion
 * @author Matias Medina
 * @author Joaquin Avalos 
 * @version versión 1, 19 de noviembre de 2022
 */
public class Avion extends JPanel{
    /** Image almacenar la imagen asociada al avion 
     * int x, y para poder modificar la posicion del objetivo
     * int vel guarda la constante de cambio (movimiento)
     * boolean dir guarda direccion elegida (true=derecha, false=izquierda)
     */ 
    private Image avion;
    private int x, y;
    private int vel=10;
    boolean dir=true;
    
    /** Constructor, se inicializan valores por defecto*/
    public Avion(){
        loadImage();
        setInitPos();
        
        this.setOpaque(false);
    }
    
    /** Realiza la carga de imagen */ 
    private void loadImage() {
        if(dir==false){
            avion = new ImageIcon("Imagenes/AvionL.png").getImage();
            
        }else{
            avion = new ImageIcon("Imagenes/AvionR.png").getImage();
        }
    }
    
    /** cambia la posicion en el eje X
    * @param x1 int 
    */
    public void CambiarX(int x1){
        x = x + x1;    
    }
    
    /** cambia la posicion en el eje Y
    * @param y1 int 
    */
    public void CambiarY(int y1){
        if(y>10 && y<300){
            y = y + y1;    
        }
        if(y<=10){
            y = y+10;
        }
        if(y>=300){
            y = y-10;
        }
    }
    
    /**@return posicion actual en X */
    public int getPosX(){
        return x;
    }
    
    /**@return posicion actual en Y */
    public int getPosY(){
        return y;
    }
    
    /** Cambia la dirección
    * @param b boolean asociado a la direccion 
    */
    public void setDireccion(boolean b){
        dir=b;
        
        if(dir==false){
            avion = new ImageIcon("Imagenes/AvionL.png").getImage();
            this.repaint();
        }else{
            avion = new ImageIcon("Imagenes/AvionR.png").getImage();
            this.repaint();
        }
    }
    
    /** inicializa la posicion original*/
    public void setInitPos(){
        if(dir==true){
            x=0;
            y=100;
        }else{
            x=1080;
            y=100;
        }
    }
    
    /** Realiza el cambio de posicion*/
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
    
    public void ResetPos(){
        x=0;
        y=100;
        dir = true;
        vel=10;
        
        avion = new ImageIcon("Imagenes/AvionR.png").getImage();
        this.repaint();
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
