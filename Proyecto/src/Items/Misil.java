package Items;

import java.awt.*;
import javax.swing.*;
import Metodos.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

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
    private boolean v, cardir;
    public boolean detected, colision, colision2;
    private int x, y;
    private int vel=0;
    boolean dir=true;
    Avion av;
    Objetivo car;
    Angular angular;
    public int x1=-1000;
    public int x2=-1000;
    private double distancia;
    
    /** Constructor, se inicializan valores por defecto*/
    public Misil(Avion av, Objetivo obj){
        v = false;
        car=obj;
        cardir = car.dir;
        colision = false;
        colision2 = false;
        detected=false;
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
        x = x + x1;    
    }
    
    /** cambia la posicion en el eje Y
    * @param y1 int 
    */
    public void CambiarY(int y1){
        if(y>35 && y<325){
            y = y + y1;    
        }
        if(y<=35){
            y = y+10;
        }
        if(y>=325){
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
    
    public void setVel(int v){
        vel=v;
    }
    
    public void Lanzamiento(){
        v = true;
    }
    
    /** Cambia la dirección
    * @param b boolean asociado a la direccion 
    */
    public void setDireccion(boolean b){
        dir=b;
        
        if(dir==false){
            misil = new ImageIcon("Imagenes/MisilL.png").getImage();
            this.repaint();
            
        }else{
            misil = new ImageIcon("Imagenes/MisilR.png").getImage();
            this.repaint();
        }
    }
    
    /** inicializa la posicion original*/
    public void setInitPos(){
        if(dir==true){
            x=40;
            y=125;
        }else{
            x=1090;
            y=125;
        }
    } 
    
    /** Realiza el cambio de posicion*/
    public void mover(){
        if(dir==true && colision==false){
            x = x+vel;
            if(x>=1240){
                x = -60;
            }
        }
        if(dir==false && colision==false){
            x = x-vel;
            if(x<=-90){
                x=1210;
            }   
        }
        if(v==true && this.getPosY()<=590){
            y = y+2;
            if(this.getPosY()>590){
                colision=true;
            }
        }
        super.repaint();
    }
    
    public void mover2(){
        if(dir==true && colision==false){
            x = x+vel;
            if(x>=1240){
                x = -60;
            }
        }
        if(dir==false && colision==false){
            x = x-vel;
            if(x<=-90){
                x=1210;
            }   
        }
        if(v==true && this.getPosY()<=590){
            y = y+3;
            if(this.getPosY()>590){
                colision=true;
            }
        }
        super.repaint();
    }
    
    public void ResetPos(){
        x=40;
        y=125;
        dir = true;
        vel=10;
        v=false;
        colision=false;
        
        misil = new ImageIcon("Imagenes/MisilR.png").getImage();
        this.repaint();
    }
    
    public void Deteccion(){
        int dif = 590-(this.getPosY()+50);
        distancia = Angular.distEntre2Puntos(this.getPosX(), this.getPosY(), car.getPosX(), car.getPosY());
        
        if(dir==true){
            x1 = this.getPosX()+50;
            x2 = this.getPosX()+350;
        }
        
        if(dir==false){
            x2 = this.getPosX();
            x1 = this.getPosX()-300;
        }
        
        if((car.getX()>x1 && car.getX()<x2 && dif<=250)||(car.getX()+100>x1 && car.getX()+100<x2 && dif<=250 && distancia<500)){
            detected=true;
            cardir=car.dir;
            System.out.println("Detectado");
        }
        
        if(detected==true && colision==false && colision2==false){
            float angulo = Angular.anguloPI(this.getLocation(),car.getLocation());
            if(dir==true){
                angulo = -((angulo*180)/(float)Math.PI);
            }else{
                angulo = (angulo*180)/(float)Math.PI;
            }
            System.out.println(angulo+"");
            Rotar((double) angulo);
        }
    }
    
    public void NoDeteccion(){     
        double distancia = Angular.distEntre2Puntos(this.getX(), this.getPosY(), car.getX(), car.getY());
        
        if(car.getX()+100<x1 && detected==true && car.getX()>0 && car.getX()<1200 && distancia<500){
            dir=false;
            /*misil = new ImageIcon("Imagenes/MisilL.png").getImage();*/
            detected=false;
            System.out.println("No Detectado");
            if(this.getPosX()<(car.getPosX()+100) && car.getPosX()<(this.getPosX()+50)){
                detected=true;
                System.out.println("Detectado");
            }
        }
        
        if(car.getX()>x2 && detected==true && car.getX()>0 && car.getX()<1200 && distancia<500){
            dir=true;
            /*misil = new ImageIcon("Imagenes/MisilR.png").getImage();*/
            detected=false;
            System.out.println("No Detectado");
            if(this.getPosX()<(car.getPosX()+100) && car.getPosX()<(this.getPosX()+50)){
                detected=true;
                System.out.println("Detectado");
            }
        }
    }
    
    public void ColisionCar(){
        if(this.getY()>=570 && dir==true && (this.getX()+45>car.getX()+10) && (this.getX()+45)<car.getX()+90){
            colision2=true;
            misil = new ImageIcon("Imagenes/Explosion.gif").getImage();
        }
        if(this.getY()>=570 && dir==false && (this.getX()+5>car.getX()+10) && (this.getX()+5<car.getX()+90)){
            colision2=true;
            misil = new ImageIcon("Imagenes/Explosion.gif").getImage();
        }
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
    
    
    public BufferedImage rotate(BufferedImage image, Double degrees) {
        double radians = Math.toRadians(degrees);
        double sin = Math.abs(Math.sin(radians));
        double cos = Math.abs(Math.cos(radians));
        int newWidth = (int) Math.round(image.getWidth() * cos + image.getHeight() * sin);
        int newHeight = (int) Math.round(image.getWidth() * sin + image.getHeight() * cos);

        BufferedImage rotate = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = rotate.createGraphics();
        int x = (newWidth - image.getWidth()) / 2;
        int y = (newHeight - image.getHeight()) / 2;
        AffineTransform at = new AffineTransform();
        at.setToRotation(radians, x + (image.getWidth() / 2), y + (image.getHeight() / 2));
        at.translate(x, y);
        g2d.setTransform(at);
        g2d.drawImage(image, 0, 0, null);
        g2d.dispose();
        return rotate;
    }
    
    public void Rotar(Double degrees){
        if(dir==true){
            try {
                BufferedImage original = ImageIO.read(new File("Imagenes/MisilR.png"));
                BufferedImage rotated = rotate(original, degrees);

                misil = new ImageIcon(rotated).getImage();
                this.repaint();

                /*JOptionPane.showMessageDialog(this, misil, null, JOptionPane.PLAIN_MESSAGE, null);*/
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        if(dir==false){
            try {
                BufferedImage original = ImageIO.read(new File("Imagenes/MisilL.png"));
                BufferedImage rotated = rotate(original, degrees);

                misil = new ImageIcon(rotated).getImage();
                this.repaint();

                /*JOptionPane.showMessageDialog(this, misil, null, JOptionPane.PLAIN_MESSAGE, null);*/
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
