package Items;

import Utils.Vector2;
import java.awt.*;
import javax.swing.*;
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
     * float x, float y para poder modificar la posicion del objetivo
     * float vel guarda la constante de cambio (movimiento)
     * boolean dir guarda direccion elegida (true=derecha, false=izquierda)
     * boolean v utilizado para asociar su posicion a la del avion
     */ 
    Image misil;
    float x, y;
    float angulo; // 0 - 360, sentido del reloj
    float radio = 300;
    float velAngular = 5f;
    private float v0;
    float velocidad = v0 = 10f;
    float t = 30f;
    boolean lanzamiento, deteccion, colision;
    Avion avion;
    Objetivo car;
    
    /** Constructor, se inicializan valores por defecto*/
    public Misil(Avion av, Objetivo obj){
        lanzamiento=false;
        deteccion=false;
        colision=false;
        avion=av;
        car=obj;
        angulo=av.getAngulo();
        velocidad= av.getVelocidad();
        
        setInitPos();
        
        loadImage();
        this.setOpaque(false);
    }
    
    /** Realiza la carga de imagen */    
    private void loadImage() {
        Rotar((double)angulo);
         
    }
    /**
     * Metodo Setter de posicion inicial
     */
    public void setInitPos(){
        if(angulo==0){
            x=40;
            y=125;
        }
        if(angulo==180){
            x=1110;
            y=125;
        }
        Rotar((double)angulo);
    }
    /**
     * Metodo getter de Posicion en el eje x
     * @return x
     */
    public float getPosX(){
        return x;
    }
    /**
     * Metodo Getter de Posicion en el eje y
     * @return y
     */
    public float getPosY(){
        return y;
    }
    /**
     * Metodo que cambia la posicion del misil dependiendo de su posicion en
     * la simulacion y el parametro y1
     * @param y1 entero que se suma a la posicion actual del misil, dependiendo
     * de su posicion
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
    
    /**
     * Metodo getter de velocidad
     * @return velocidad
     */
    public float getVelocidad(){
        return velocidad;
    }
    /**
     * Metodo setter de velocidad
     * @param v 
     */
    public void setVelocidad(float v){
        velocidad = v;
    }
    /**
     * Metodo setter de direccion en cierto angulo
     * @param d 
     */
    public void setDireccion(float d){
        angulo=d;
    }
    /**
     * Metodo que permite el lanzamiento y rotacion inicial del misil
     * dependiendo de su direccion
     * @param l 
     */
    public void Lanzamiento(boolean l){
        lanzamiento=l;
        if(lanzamiento == true){
            if(angulo==0){
                angulo = 10;
            }else{
                angulo = 170;
            }
            Rotar((double)angulo);
        }   
    }
    /**
     * Metodo que reinicia las posiciones y condiciones iniciales
     * del misil
     */
    public void Reset(){
        x=40;
        y=125;
        angulo=0;
        velocidad=v0;
        colision=false;
        deteccion=false;
        lanzamiento=false;
        Rotar((double)angulo);
    }
    
    /**
     * Metodo que pinta la imagen de misil
     * @param g 
     */
    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(misil, 0, 0, null);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
    
    
    /**
     * Metodo que permite detectar al objetivo
     * @return true o false
     */
    public boolean checkearObjetivo() {
        Vector2 dist = new Vector2((car.getPosX()+50) - this.x, car.getPosY() - this.y);

        // si el objetivo esta fuera del rango radial, descartar
        float mag = dist.magnitud();
        if (mag > radio) {
            deteccion=false;
            return false;
        }

        Vector2 frente = new Vector2((float) Math.cos(Math.toRadians(angulo)), (float) Math.sin(Math.toRadians(angulo)));

        dist.normalizar();
        frente.normalizar();

        // si el objetivo esta frente al misil, entonces retornar verdadero
        if(Vector2.dot(dist, frente) > 0f){
            deteccion=true;
            return true;
        } // sino, descartar
        else{
            deteccion=false; 
            return false;
        } 
    }
    /**
     * Metodo que permite girar y rotar el misil
     */
    public void girar() {
        Vector2 dist = new Vector2((car.getPosX()+50) - this.x, car.getPosY() - this.y);

        // pasamos el angulo a Vector en 2 dimensiones
        float anguloObjetivo = (float) Math.toDegrees(Math.atan2(dist.y, dist.x));

        // encontrar la direccion con menor dif de angulo
        float delta = anguloObjetivo - angulo;
        float delta2 = anguloObjetivo - angulo - 360f;
        float delta3 = anguloObjetivo - angulo + 360f;
        if (Math.abs(delta2) < Math.abs(delta) && Math.abs(delta2) < Math.abs(delta3)) {
            delta = delta2;
        }
        if (Math.abs(delta3) < Math.abs(delta) && Math.abs(delta3) < Math.abs(delta2)) {
            delta = delta3;
        }

        // si la diferencia de angulo es menor a la velocidad angular, rotar directamente al objetivo
        if (Math.abs(delta) < velAngular) {
            angulo = anguloObjetivo;
        } else {
            angulo += Math.signum(delta) * velAngular;
        }

        // ajuste de angulo final al rango -180, 180
        if (angulo < -180) {
            angulo += 360f;
        } else if (angulo > 180) {
            angulo -= 360f;
        }
        if(angulo == -180){
            angulo=-175;
        }
        if(angulo == 0){
            angulo=30;
        }
        Rotar((double)angulo);
    }
    /**
     * Metodo que permite el movimiento del misil
     */
    public void mover(){
        if(checkearObjetivo() && lanzamiento==true){
            girar();
            
        }
        
        if(colision==false){
            Vector2 frente = new Vector2((float) Math.cos(Math.toRadians(angulo)), (float) Math.sin(Math.toRadians(angulo)));
            frente.escalar(velocidad);

            x += frente.x;
            y += frente.y;

            if(x > 1200) x = -100;
            if(x < -100) x = 1200;

            if(y > 590) y -= frente.y;
            if(y > 580) colision=true;
        }else{
            misil = new ImageIcon("Imagenes/Explosion.gif").getImage();
        }
    }
    /**
     * Metodo que permite conocer si el misil colisiono con el objetivo.
     */
    public void Colision() {
        if ((this.x < (car.getPosX() + 90) && this.x > car.getPosX() && (this.y + 50) > (car.getPosY() + 20)) || ((this.x + 50) > (car.getPosX() + 10) && (this.x + 50) < (car.getPosX() + 90) && (this.y + 50) > (car.getPosY() + 20))) {
            colision = true;
            car.setColision();
        }
    }
    /**
     * Metodo getter de estado de colision
     * @return colision, true o false
     */
    public boolean getColision(){
        return colision;
    }
    
    /**
     * Metodo que permite el calculo del angulo de rotacion del misil y 
     * rota la imagen en el angulo correspondiente
     * @param image imagen del misil
     * @param degrees angulo de rotacion
     * @return 
     */
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
    /**
     * Metodo que pinta la imagen rotada
     * @see rotate
     * @param degrees angulo de rotacion
     */
    public void Rotar(Double degrees){
        try {
            BufferedImage original = ImageIO.read(new File("Imagenes/MisilR.png"));
            BufferedImage rotated = rotate(original, degrees);

            misil = new ImageIcon(rotated).getImage();
            this.repaint();

        } catch (IOException ex) {
            ex.printStackTrace();
        } 
    }
    
}
