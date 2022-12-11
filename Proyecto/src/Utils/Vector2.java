package Utils;
/**
 * Metodo que permite calcular el vector director
 * @author Matias Medina
 * @author Joaquin Avalos
 */
public class Vector2{
    public float x,y;
    /**
     * Constructor de clase Vector2
     * @param x: coordenada en el eje x
     * @param y: coordenada en el eje y
     */
    public Vector2(float x, float y){
        this.x = x;
        this.y = y;
    }
    /**
     * Metodo dot que calcula el producto punto entre dos vectores
     * @param a vector a
     * @param b vector b
     * @return producto punto
     */
    public static float dot(Vector2 a, Vector2 b){
        return a.x * b.x + a.y * b.y;
    }
    /**
     * Metodo escalar que multiplica por un escalar al vector
     * @param f float escalar
     */
    public void escalar(float f){
        x *= f;
        y *= f;
    }
    /**
     * Metodo magnitud que calcula la magnitud del vector
     * @return magnitud del vector
     */
    public float magnitud(){
        return (float)Math.sqrt(x*x + y*y);
    }
    /**
     * Metodo normalizar que normaliza un vector
     * @see magnitud
     */
    public void normalizar(){
        float mag = magnitud();
        x /= mag;
        y /= mag;
    }
}
