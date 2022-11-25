package Items;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/** 
 * Clase Objetivo, objetivo a destruir en la animación
 * @author Matias Medina
 * @author Joaquin Avalos 
 * @version versión 1, 17 de noviembre de 2022
 */

public class Objetivo extends JPanel{
    /** Image almacenar la imagen asociada al objetivo 
     * int x, y para poder modificar la posicion del objetivo
     * int vel guarda la constante de cambio (movimiento)
     * boolean dir guarda direccion elegida (true=derecha, false=izquierda) 
     */ 
    private Image objetivo;
    private int x;
    static private int y;
    static private int posx=0;
    static private int posy=580;
    private int vel=5;
    boolean dir=true;
    public Rectangle solidArea;
    
    /** Constructor, se inicializan valores por defecto*/
    public Objetivo(){
        loadImage();
        x=0;
        y=580;
        this.setOpaque(false);
        
        solidArea = new Rectangle(this.getPosX(),this.getPosY(),30,30);
        
        setInitPos();
    }
    
    /** Realiza la carga de imagen */
    private void loadImage() {
        if(dir==false){
            objetivo = new ImageIcon("Imagenes/AutoL.png").getImage();
            
        }else{
            objetivo = new ImageIcon("Imagenes/AutoR.png").getImage();
        }
    }
    
    /** cambia la posicion en el eje X
    * @param x1 int 
    */
    public void CambiarX(int x1){
        x=x1;    
    }
    
    /** cambia la posicion en el eje Y
    * @param y1 int 
    */
    public void CambiarY(int y1){
        y = y1;
    }
    
    /**@return posicion actual en X */
    public int getPosX(){
        return x;
    }
    
    /**@return posicion actual en Y */
    public int getPosY(){
        return y;
    }
    
    public void setInitPos(){
        if(dir==true){
            x=0;
            y=580;
        }else{
            x=1080;
            y=580;
        }
    }
    
    /** Cambia la dirección
    * @param b boolean asociado a la direccion 
    */
    public void setDireccion(boolean b){
        if(dir==true && b==false){
            vel = (vel*-1);
        }
        if(dir==false && b==true){
            vel = (vel*-1);
        }
        dir=b;
        vel = (vel*-1);
        
        if(dir==false){
            objetivo = new ImageIcon("Imagenes/AutoL.png").getImage();
            this.repaint();
            
        }else{
            objetivo = new ImageIcon("Imagenes/AutoR.png").getImage();
            this.repaint();
        }
    }
    
    public boolean CualDireccion(){
        return dir;
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
    }
    
    /** Cambiar la velocidad actual*/
    public void setVel(int v){
        if(dir==true){
            vel=v;
        }
        if(dir==false){
            vel=-v;  
        }
        
    }
    
    /** @return velocidad*/
    public int getVel(){
        return vel;
    }
    
    public void ResetPos(){
        x=0;
        y=580;
        dir = true;
        vel=5;
        
        objetivo = new ImageIcon("Imagenes/AutoR.png").getImage();
        this.repaint();
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

