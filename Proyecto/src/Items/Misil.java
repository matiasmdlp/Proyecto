package Items;

import java.awt.*;
import javax.swing.*;

/** 
 * Clase Misil el objeto lanzado
 * @author Matias Medina
 * @author Joaquin Avalos 
 * @version versión 1, 18 de noviembre de 2022
 */
public class Misil extends JPanel{
    /** Image almacenar la imagen asociada al misil 
     * int x, y para poder modificar la posicion del objetivo
     * int vel guarda la constante de cambio (movimiento)
     * boolean dir guarda direccion elegida (true=derecha, false=izquierda)
     * boolean v utilizado para asociar su posicion a la del avion
     */ 
    private Image misil;
    private boolean v;
    private int x, y;
    private int vel=0;
    boolean dir=true;
    Avion av;
    
    /** Constructor, se inicializan valores por defecto*/
    public Misil(boolean v, Avion av){
        this.v = v;
        this.av=av;
        vel=av.getVel();
        
        loadImage();
        setInitPos();
        
        this.setOpaque(false);
    }
    
    /** Realiza la carga de imagen */    
    private void loadImage() {
        if(dir==false){
            misil = new ImageIcon("Imagenes/MisilL.png").getImage();
            
        }else{
            misil = new ImageIcon("Imagenes/MisilR.png").getImage();
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
        y=y1;    
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
    }
    
    /** inicializa la posicion original*/
    private void setInitPos(){
        if(dir==true){
            x=av.getPosX()+40;
            y=av.getPosY()+25;
        }else{
            x=av.getPosX()+10;
            y=av.getPosY()+25;
        }
    } 
    
    /** Realiza el cambio de posicion*/
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
