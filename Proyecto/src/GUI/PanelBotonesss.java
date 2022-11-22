
package GUI;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

public class PanelBotonesss extends JPanel {
    private JButton BotonAbajo;
    private JButton BotonArriba;
    private JButton BotonDerecha;
    private JButton BotonIzquierda;
    private JButton BotonLaunch;
    private JComboBox<String> CualModificamos;
    private JToggleButton InicioStopBoton;
    private JLabel L_Altura;
    private JLabel L_CualModificamos;
    private JLabel L_Direccion;
    private JLabel L_LanzarMisil;
    private JLabel L_Velocidad;
    private JButton ResetBoton;
    private JSlider S_Velocidad;
    
    
    public PanelBotonesss(){
        S_Velocidad = new JSlider();
        BotonIzquierda = new JButton();
        BotonDerecha = new JButton();
        BotonArriba = new JButton();
        BotonAbajo = new JButton();
        BotonLaunch = new JButton();
        CualModificamos = new JComboBox<>();
        L_Altura = new JLabel("Altura");
        L_Direccion = new JLabel("Direccion");
        L_CualModificamos = new JLabel("¿Cual Modificamos?");
        L_LanzarMisil = new JLabel("Lanzar el Misil");
        L_Velocidad = new JLabel("Velocidad");
        ResetBoton = new JButton("Reset");
        InicioStopBoton = new JToggleButton("Inicio/Stop");
        
        
        // PANEl
        this.setBounds(0, 650, 1200, 250);
        this.setBackground(Color.white);
        
        //BotonIzquierda
        
        //BotonIzquierda.setText("Izquierda");
        BotonIzquierda.setBounds(660,130,55, 71);
        ImageIcon iconIzq = new ImageIcon("Imagenes/L.png");
        iconIzq = new ImageIcon(iconIzq.getImage().getScaledInstance(BotonIzquierda.getWidth(), BotonIzquierda.getHeight(), BufferedImage.SCALE_SMOOTH));
        BotonIzquierda.setIcon(iconIzq);
       
        BotonIzquierda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BotonIzquierdaActionPerformed(evt);
            }
        });
        this.add(BotonIzquierda);
        //BotonDerecha

        //BotonDerecha.setText("Derecha");
        BotonDerecha.setBounds(761,130,55, 71);
        ImageIcon iconDer = new ImageIcon("Imagenes/R.png");
        iconDer = new ImageIcon(iconDer.getImage().getScaledInstance(BotonDerecha.getWidth(), BotonDerecha.getHeight(), BufferedImage.SCALE_SMOOTH));
        BotonDerecha.setIcon(iconDer);
        BotonDerecha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BotonDerechaActionPerformed(evt);
            }
        });
        this.add(BotonDerecha);
        
        //BotonArriba
        //BotonArriba.setText("Arriba");
        BotonArriba.setBounds(50, 717, 55, 71);
        ImageIcon iconArri = new ImageIcon("Imagenes/UP.png");
        iconArri = new ImageIcon(iconArri.getImage().getScaledInstance(BotonArriba.getWidth(), BotonArriba.getHeight(), BufferedImage.SCALE_SMOOTH));
        BotonArriba.setIcon(iconArri);
        BotonArriba.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BotonArribaActionPerformed(evt);
            }
        });
        add(BotonArriba);
        
        //BotonAbajo

        //BotonAbajo.setText("Abajo");
        BotonAbajo.setBounds(50, 785, 55, 71);
        ImageIcon iconAbaj = new ImageIcon("Imagenes/D.png");
        iconAbaj = new ImageIcon(iconAbaj.getImage().getScaledInstance(BotonAbajo.getWidth(), BotonAbajo.getHeight(), BufferedImage.SCALE_SMOOTH));
        BotonAbajo.setIcon(iconAbaj);
        BotonAbajo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BotonAbajoActionPerformed(evt);
            }
        });
        add(BotonAbajo);
        
        //BotonLaunch
        BotonLaunch.setBounds(840,125,100,100);
        //BotonLaunch.setText("Launch");
        ImageIcon iconLaunch = new ImageIcon("Imagenes/Boton.png");
        iconLaunch = new ImageIcon(iconLaunch.getImage().getScaledInstance(BotonLaunch.getWidth(), BotonLaunch.getHeight(), BufferedImage.SCALE_SMOOTH));
        BotonLaunch.setIcon(iconLaunch);
        BotonLaunch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BotonLaunchActionPerformed(evt);
            }
        });
        add(BotonLaunch);
        
        //CualModificamos
        CualModificamos.setModel(new DefaultComboBoxModel<>(new String[] { "Auto", "Avion"}));
        CualModificamos.setBounds(100, 717, 70, 30);
        add(CualModificamos);
        
        //Reset
        //ResetBoton.setText("Reset");
        ResetBoton.setBounds(23,785,55,71);
        ResetBoton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BotonResetBotonActionPerformed(evt);
            }
        });
        
        add(ResetBoton);
        
        //InicioStop

        InicioStopBoton.setText("Inicio/Stop");
        InicioStopBoton.setBounds(23, 717, 55, 71);
        add(InicioStopBoton);
        
        //Slider
        S_Velocidad.setBounds(100, 770, 700, 50);
        add(S_Velocidad);
        
        
        //LABELS
        L_Altura.setText("Altura");

        L_Direccion.setText("Direccion");

        L_CualModificamos.setText("¿Cual Modificamos?");

        L_LanzarMisil.setText("Lanzar el Misil");

        L_Velocidad.setText("Velocidad");



    }
    
    private void BotonAbajoActionPerformed(ActionEvent evt) {

    }

    private void BotonDerechaActionPerformed(ActionEvent evt) {

    }

    private void BotonIzquierdaActionPerformed(ActionEvent evt) {

    }

    private void BotonArribaActionPerformed(ActionEvent evt) {

    }
    private void BotonLaunchActionPerformed(ActionEvent evt) {
        
    }
    private void BotonResetBotonActionPerformed(ActionEvent evt) {

    }
    
    /*@Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
    }
*/
}
