package proyecto;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.Timer;

public class Ventana extends JFrame implements ActionListener{
    private Timer timer, timer2;
    PanelFondo p;
            
    public Ventana(){
        super();
        p = new PanelFondo();
        p.setBounds(0, 0, 1200, 650);
        
        timer = new Timer(100,null); 
        timer.addActionListener(this);
        timer2 = new Timer(100,null);
        timer2.addActionListener(this);
        
        this.setBackground(Color.black);
        this.add(p);
        
        this.setLayout(new BorderLayout());
        this.setTitle("Proyecto");
        this.setSize(1200, 900);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        /*System.out.println("*");*/ 
   }
}
