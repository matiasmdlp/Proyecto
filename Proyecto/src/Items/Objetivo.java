package Items;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Graphics;

public class Objetivo extends JPanel{
    public Image objetivoimg;
    public URL objetivo;
    
    public Objetivo(int x, int y){
        this.setBounds(x, y, 100, 100);
        
        objetivo = this.getClass().getResource("/Imagenes/Auto_R.png");
        objetivoimg = new ImageIcon(objetivo).getImage();
    }
    
    @Override
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        g.drawImage(objetivoimg, 0, 0, getWidth(), getHeight(), this);
    }
}

