package GUI;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.image.BufferedImage;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.JToggleButton;
import proyecto.*;

public class Botones {
    private JButton UP, DOWN, RIGHT, LEFT, Boton, Reset;
    JToggleButton avion, objetivo, Start;
    JSlider velocidad;
    Ventana panel;
    
    public Botones(Ventana v){
        panel = v;
        
        UP = new JButton();
        UP.setBounds(300, 660, 70, 70);
        UP.setForeground(Color.white);
        UP.setOpaque(false);
        UP.setContentAreaFilled(false);
        ImageIcon iconUP = new ImageIcon("Imagenes/UP.png");
        iconUP = new ImageIcon(iconUP.getImage().getScaledInstance(UP.getWidth(), UP.getHeight(), BufferedImage.SCALE_SMOOTH));
        UP.setIcon(iconUP);
        panel.add(UP);
        
        DOWN = new JButton();
        DOWN.setBounds(300, 760, 70, 70);
        DOWN.setForeground(Color.white);
        DOWN.setOpaque(false);
        DOWN.setContentAreaFilled(false);
        ImageIcon iconDown = new ImageIcon("Imagenes/D.png");
        iconDown = new ImageIcon(iconDown.getImage().getScaledInstance(DOWN.getWidth(), DOWN.getHeight(), BufferedImage.SCALE_SMOOTH));
        DOWN.setIcon(iconDown);
        panel.add(DOWN);
        
        RIGHT = new JButton();
        RIGHT.setBounds(400, 710, 70, 70);
        RIGHT.setForeground(Color.white);
        RIGHT.setOpaque(false);
        RIGHT.setContentAreaFilled(false);
        ImageIcon iconRight = new ImageIcon("Imagenes/R.png");
        iconRight = new ImageIcon(iconRight.getImage().getScaledInstance(RIGHT.getWidth(), RIGHT.getHeight(), BufferedImage.SCALE_SMOOTH));
        RIGHT.setIcon(iconRight);
        panel.add(RIGHT);
        
        LEFT = new JButton();
        LEFT.setBounds(200, 710, 70, 70);
        LEFT.setForeground(Color.white);
        LEFT.setOpaque(false);
        LEFT.setContentAreaFilled(false);
        ImageIcon iconLeft = new ImageIcon("Imagenes/L.png");
        iconLeft = new ImageIcon(iconLeft.getImage().getScaledInstance(LEFT.getWidth(), LEFT.getHeight(), BufferedImage.SCALE_SMOOTH));
        LEFT.setIcon(iconLeft);
        panel.add(LEFT);
        
        Boton = new JButton();
        Boton.setBounds(800, 670, 150, 150);
        Boton.setForeground(Color.white);
        Boton.setOpaque(false);
        Boton.setContentAreaFilled(false);
        ImageIcon iconBoton = new ImageIcon("Imagenes/Boton.png");
        iconBoton = new ImageIcon(iconBoton.getImage().getScaledInstance(Boton.getWidth(), Boton.getHeight(), BufferedImage.SCALE_SMOOTH));
        Boton.setIcon(iconBoton);
        panel.add(Boton);
        
        Start = new JToggleButton("Start / Stop");
        Start.setFont(new Font("Arial", Font.PLAIN, 20));
        Start.setBounds(1000, 670, 150, 70);
        Start.setForeground(Color.black);
        /*Start.setOpaque(false);
        Start.setContentAreaFilled(false);
        ImageIcon iconStart = new ImageIcon("Imagenes/Boton.png");
        iconStart = new ImageIcon(iconStart.getImage().getScaledInstance(Boton.getWidth(), Boton.getHeight(), BufferedImage.SCALE_SMOOTH));
        Start.setIcon(iconStart);*/
        panel.add(Start);
        
        Reset = new JButton("Reset");
        Reset.setFont(new Font("Arial", Font.PLAIN, 20));
        Reset.setBounds(1000, 760, 150, 70);
        Reset.setForeground(Color.black);
        /*Reset.setOpaque(false);
        Reset.setContentAreaFilled(false);
        ImageIcon iconReset = new ImageIcon("Imagenes/Boton.png");
        iconReset = new ImageIcon(iconReset.getImage().getScaledInstance(Boton.getWidth(), Boton.getHeight(), BufferedImage.SCALE_SMOOTH));
        Reset.setIcon(iconReset);*/
        panel.add(Reset);
        
        avion = new JToggleButton();
        avion.setBounds(20, 680, 150, 50);
        avion.setForeground(Color.white);
        avion.setOpaque(true);
        avion.setContentAreaFilled(true);
        ImageIcon iconavion = new ImageIcon("Imagenes/Avion_R.png");
        iconavion = new ImageIcon(iconavion.getImage().getScaledInstance(avion.getWidth(), avion.getHeight(), BufferedImage.SCALE_SMOOTH));
        avion.setIcon(iconavion);
        panel.add(avion);
        
        objetivo = new JToggleButton();
        objetivo.setBounds(20, 760, 150, 50);
        objetivo.setForeground(Color.white);
        objetivo.setOpaque(true);
        objetivo.setContentAreaFilled(true);
        ImageIcon iconaobj = new ImageIcon("Imagenes/Auto_R.png");
        iconaobj = new ImageIcon(iconaobj.getImage().getScaledInstance(avion.getWidth(), avion.getHeight(), BufferedImage.SCALE_SMOOTH));
        objetivo.setIcon(iconaobj);
        panel.add(objetivo);
        
        
        /*velocidad = new JSlider(JSlider.HORIZONTAL, 1,10);
        velocidad.setBounds(500, 710, 200, 50);
        velocidad.setMajorTickSpacing(10);
        velocidad.setMinorTickSpacing(1);
        velocidad.setPaintTicks(true);
        velocidad.setPaintLabels(true);
        panel.add(velocidad);*/
    }
    
    
}
