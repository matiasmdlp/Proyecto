package Utils;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
/**
 * Metodo que busca rotar la imagen
 * @author Matias Medina
 * @author Joaquin Avalos
 */
public class RotarIMG {
    public RotarIMG(){
        
    }
    /**
     * Metodo que permite calcular la rotacion de una imagen.
     * @param image imagen
     * @param degrees angulo
     * @return rotate imagen rotada
     */
    public BufferedImage rotate(BufferedImage image, Double degrees) {
        // Calcula el tamaño de la nueva imagen basandose en el angulo de rotacion.
        double radians = Math.toRadians(degrees);
        double sin = Math.abs(Math.sin(radians));
        double cos = Math.abs(Math.cos(radians));
        int newWidth = (int) Math.round(image.getWidth() * cos + image.getHeight() * sin);
        int newHeight = (int) Math.round(image.getWidth() * sin + image.getHeight() * cos);

        // Crea la nueva imagen
        BufferedImage rotate = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = rotate.createGraphics();
        int x = (newWidth - image.getWidth()) / 2;
        int y = (newHeight - image.getHeight()) / 2;
        AffineTransform at = new AffineTransform();
        at.setToRotation(radians, x + (image.getWidth() / 2), y + (image.getHeight() / 2));
        at.translate(x, y);
        g2d.setTransform(at);
        // Pinta la nueva imagen
        g2d.drawImage(image, 0, 0, null);
        g2d.dispose();
        return rotate;
    }
}
