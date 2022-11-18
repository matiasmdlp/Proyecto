package Metodos;

import java.awt.Point;

public class PuntosParabola {
    static double g = 9.8; 
    
    /**
     * Calcula el siguiente punto para un tiempo t
     * @param x0: posicion inicial(o bien la posicion en el t anterior)
     * @param vx0: velocidad inicial con respecto al eje X (o bien la velocidad en el t anterior)
     * @param y0: posicion inicial(o bien la posicion en el t anterior)
     * @param vy0: velocidad inicial con respecto al eje Y (o bien la velocidad en el t anterior)
     * @param angulo: angulo con respecto a la horizontal (en grados, se realiza la convercion a radianes en el metodo)
     * @param t: tiempo en el cual se va a evaluar
     * @return 
     */
    public  static Point generaPuntoParabola(int x0, double vx0, int y0, double vy0, int angulo, int t){
        double θ = (double)(angulo * Math.PI) / 180;
        int x = (int) ((double)x0 + ( vx0 * Math.cos(θ) * t));
        int y = (int) ((double)y0 + ( vy0 * Math.sin(θ)) - ((g * t * t) / 2)); 
        Point p = new Point(x, y);
        return p;
    }
    
    /**
     * Calcula el punto en el eje Y en un tiempo t
     * @param y0: posicion inicial(o bien la posicion en el t anterior)
     * @param vy0: velocidad inicial con respecto al eje Y (o bien la velocidad en el t anterior)
     * @param angulo: angulo con respecto a la horizontal (en grados, se realiza la convercion a radianes en el metodo)
     * @param t: tiempo en el cual se va a evaluar
     * @return 
     */
    public int TrayerctoriaVertical(int y0, double vy0, int angulo, int t){
        double θ = (double)(angulo * Math.PI) / 180;
        int y = (int) ((double)y0 + ( vy0 * Math.sin(θ)) - ((g * t * t) / 2)); // La velocidad en y es 0, la formula se puede simplificar aun mas 
        return y;
    }
    
    
    /**
     * Calcula el punto en el eje X en un tiempo t
     * @param x0: posicion inicial(o bien la posicion en el t anterior)
     * @param vx0: velocidad inicial con respecto al eje X (o bien la velocidad en el t anterior)
     * @param angulo: angulo con respecto a la horizontal (en grados, se realiza la convercion a radianes en el metodo)
     * @param t: tiempo en el cual se va a evaluar
     * @return 
     */
    public int TrayerctoriaHorizontal(int x0, double vx0, int angulo, int t){
        double θ = (double)(angulo * Math.PI) / 180;
        int x = (int) ((double)x0 + ( vx0 * Math.cos(θ) * t));
        return x;
    }
    
    /**
     * Calcula la velocidad iunstantanea (Vy)
     * @param t: tiempo en el cual se va a evaluar
     * @return 
     */
    public double VelocidadY(int t){
        double Vy = -g * t; 
        return Vy;
    }
    
    /**
     * Calcula el tiempo que durara el proyectil en el aire 
     * @param v0: velocidad inicial con respecto al eje X (o bien la velocidad en el t anterior)
     * @param angulo: angulo con respecto a la horizontal (en grados, se realiza la convercion a radianes en el metodo)
     * @return 
     */    
    public int TiempoDeVuelo(double v0, int angulo){
        double θ = (double)(angulo * Math.PI) / 180;
        int t = (int) ((2 * v0 * Math.sin(θ))/ g);
        return t;
    }
}
