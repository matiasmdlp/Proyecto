package Items;

import Utils.Vector2;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.*;

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
    private Image car;
    private float x, y;
    private float velocidad=3f;
    float angulo = 0;
    boolean colision=false;
    
    private float x0,y0,v0;
    
    
    /** Constructor, se inicializan valores por defecto*/
    public Objetivo(){
        loadImage();
        
        setInitPos();
        
        v0=velocidad;
        
        ValoresRandom();
        
        this.setOpaque(false);
    }
    
    /** Realiza la carga de imagen */ 
    private void loadImage() {
        if(angulo==0){
            car = new ImageIcon("Imagenes/AutoR.png").getImage();
        }else{ 
            if(angulo==180){
                car = new ImageIcon("Imagenes/AutoL.png").getImage();
            }
        }
         
    }
    
    public float getPosX(){
        return x;
    }
    public float getPosY(){
        return y;
    }
    
    public float getVelocidad(){
        return velocidad;
    }
    public void setVelocidad(float v){
        velocidad = v;
    }
    
    public float getAngulo(){
        return angulo;
    }
    public void setAngulo(float ang){
        angulo = ang;
        if(angulo==180){
            car = new ImageIcon("Imagenes/AutoL.png").getImage();
        }else{
            car = new ImageIcon("Imagenes/AutoR.png").getImage();
        }
    }
    
    public void setInitPos(){
        if(angulo==0){
            x=x0=0;
            y=y0=580;
            car = new ImageIcon("Imagenes/AutoR.png").getImage();
        }
        if(angulo==180){
            x=1100;
            y= 580;
            car = new ImageIcon("Imagenes/AutoL.png").getImage();
        }
    }
    
    public void mover(){
        if(colision==false){
            Vector2 frente = new Vector2((float) Math.cos(Math.toRadians(angulo)), (float) Math.sin(Math.toRadians(angulo)));
            frente.escalar(velocidad);

            x += frente.x;
            y += frente.y;

            if(x > 1200) x = -100 ;
            if(x < -100) x = 1200;

            if(y > 590) y -= frente.y;
        }
    }
    
    public void Reset(){
        /*x=x0;
        y=y0;
        angulo=0;
        velocidad=v0;*/
        colision=false;
        ValoresRandom();
        if(angulo==0){
            car = new ImageIcon("Imagenes/AutoR.png").getImage();
        }else{
            car = new ImageIcon("Imagenes/AutoL.png").getImage();
        }
        
    }
    
    public void ValoresRandom(){
        int numero = (int)(Math.random()*(12-4+1)+4);
        velocidad=numero;
        Random randomno = new Random();
        boolean value = randomno.nextBoolean();
        if(value==true){
            angulo=0;
            x=0;
            y=580;
            car = new ImageIcon("Imagenes/AutoR.png").getImage();
        }else{
            angulo=180;
            x=1080;
            y=580;
            car = new ImageIcon("Imagenes/AutoL.png").getImage();
        }
        
        System.out.println(angulo+" "+numero);
    }
    
    public void setColision(){
        colision=true;
    }
    
    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(car, 0, 0, null);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}

