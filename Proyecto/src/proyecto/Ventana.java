package proyecto;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

public class Ventana extends JFrame implements ActionListener{
    private final PanelFondo fondo;
    private Timer timer, timer2;
    
    public Ventana(){
        super();
        this.setLayout(new BorderLayout());
        this.setTitle("Lanzamiento de misil");
        timer = new Timer(100,null);
        timer.addActionListener(this);
        timer.start();
        timer2 = new Timer(100,null);
        timer2.addActionListener(this);
        
        fondo = new PanelFondo();
        this.getContentPane().add(fondo);
                       
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1200, 800);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("*");
    }
}
