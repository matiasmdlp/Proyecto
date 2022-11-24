package proyecto;

import GUI.VelSlider;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Ventana extends JFrame implements ActionListener{
    PanelPrincipal pp;
    PanelBotones pb;
    public Timer timer2;
    
    public Ventana(){
        super();
        setItems();
        
        this.setLayout(new BorderLayout());
        this.setTitle("Proyecto");
        this.setSize(1200, 900);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void setItems(){
        pp = new PanelPrincipal();
        this.setBackground(Color.black);
        pp.setBounds(0, 0, 1200, 650);
        this.add(pp);
        
        pb = new PanelBotones(this, pp);
        this.setBackground(Color.black);
        pb.setBounds(0, 650, 1200, 250);
        this.add(pb);
        
        timer2 = new Timer(30,null); 
        timer2.addActionListener((ActionListener) this);
        timer2.start();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        pp.print();
   }
    
}
