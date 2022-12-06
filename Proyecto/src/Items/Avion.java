package Items;

import java.awt.Image;
import java.awt.*;
import javax.swing.*;
import Metodos.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

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
    private float x, y;
    private float v0;
    private float velocidad= v0 =10f;
    float angulo = 0;
    boolean direccion=true;
    
    
    /** Constructor, se inicializan valores por defecto*/
    public Avion(){
        loadImage();
        setInitPos();
        
        
        this.setOpaque(false);
    }
    
    /** Realiza la carga de imagen */ 
    private void loadImage() {
        if(angulo==0){
            avion = new ImageIcon("Imagenes/AvionR.png").getImage();
        }else{ 
            if(angulo==180){
                avion = new ImageIcon("Imagenes/AvionL.png").getImage();
            }
        }    
    }
    
    public void setInitPos(){
        if(angulo==0){
            x=0;
            y= 100;
            avion = new ImageIcon("Imagenes/AvionR.png").getImage();
        }
        if(angulo==180){
            x=1100;
            y= 100;
            avion = new ImageIcon("Imagenes/AvionL.png").getImage();
        }
    }
    
    public float getPosX(){
        return x;
    }
    public float getPosY(){
        return y;
    }
    
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
    
    public float getVelocidad(){
        return velocidad;
    /**
     * Metodo Getter de la posicion del avion en el eje x
     * @return posicion actual en X 
     */
    public int getPosX(){
        return x;
    }
    
    /**
     * Metodo Getter de la posicion del avion en el eje y
     * @return posicion actual en Y.
     */
    public int getPosY(){
        return y;
    public void setVelocidad(float v){
        velocidad = v;
    }
    
    public float getAngulo(){
        return angulo;
    }
    public void setDireccion(float ang){
        angulo = ang;
    }
    
    public void Reset(){
        x=0;
        y=100;
        angulo=0;
        velocidad=v0;
        avion = new ImageIcon("Imagenes/AvionR.png").getImage();
    }
    
    public void mover(){
        
        Vector2 frente = new Vector2((float) Math.cos(Math.toRadians(angulo)), (float) Math.sin(Math.toRadians(angulo)));
        frente.escalar(velocidad);

        x += frente.x;
        y += frente.y;
        
        if(x > 1200) x = -100 ;
        if(x < -100) x = 1200;
        
        if(y > 590) y -= frente.y;
        
    }
    
    
    /**
     * Metodo que pinta la imagen del avion.
     * @param g Graphics 
     */
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
