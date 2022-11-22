package proyecto;

import GUI.VelSlider;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame implements ActionListener{
    PanelPrincipal pp;
    PanelBotones pb;
            
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
        
        pb = new PanelBotones(this);
        this.setBackground(Color.black);
        pb.setBounds(0, 650, 1200, 250);
        this.add(pb);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        /*System.out.println("*");*/  
   }
}
