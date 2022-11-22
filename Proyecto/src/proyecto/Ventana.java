package proyecto;

<<<<<<< Updated upstream

import GUI.PanelBotonesss;
=======
<<<<<<< HEAD

import GUI.PanelBotonesss;
=======
import GUI.VelSlider;
>>>>>>> 731c9bde6038d815491fd0025f39a42ecf653a20
>>>>>>> Stashed changes
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame implements ActionListener{
    PanelPrincipal pp;
    PanelBotonesss pb;
            
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
        
        pb = new PanelBotonesss();
        this.setBackground(Color.black);
        pb.setBounds(0, 650, 1200, 250);
        this.add(pb);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        /*System.out.println("*");*/  
   }
}
