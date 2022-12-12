
package Items;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *Test de Clase Misil
 * @author Joaquin Avalos
 * @author Matias Medina
 */
public class MisilTest {
    private int cuantomemuevo;
    private Misil misil;
    private Misil misilInic;
    private Objetivo car;
    private Avion avion;
    
    
    public MisilTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {

    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        avion = new Avion();
        car = new Objetivo();
        misil = new Misil(avion,car);
        misilInic = new Misil(avion, car);
        misilInic.x=40;
        misilInic.y=125;
        misilInic.angulo=0;
        misilInic.velocidad=10f;
        misilInic.colision=false;
        misilInic.deteccion=false;
        misilInic.lanzamiento=false;
        misilInic.Rotar((double)misilInic.angulo);
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test del metodo CambiarY, de la clase Misil.
     * Caso Correcto
     */
    @Test
    public void testCambiarYCasoCorrecto() {
        cuantomemuevo = 20;
        System.out.println("CambiarY");
        misil.y = 300;
        misil.CambiarY(cuantomemuevo);
        assertEquals(320, misil.getPosY(),0);
    }
    /**
     * Test del metodo CambiarY, de la clase Misil.
     * Caso Limite 1
     */    
    @Test
    public void testCambiarYCasoLimite() {
        cuantomemuevo = 20;
        System.out.println("CambiarY");
        misil.y = 326;
        misil.CambiarY(cuantomemuevo);
        assertEquals(316, misil.getPosY(),0);
    }
    /**
     * Test del metodo CambiarY, de la clase Misil.
     * Caso Limite 2
     */
    @Test
    public void testCambiarYCasoLimite2() {
        cuantomemuevo = 20;
        System.out.println("CambiarY");
        misil.y = 35;
        misil.CambiarY(cuantomemuevo);
        assertEquals(45, misil.getPosY(),0);
    }
    /**
     * Test del metodo CambiarY, de la clase Misil.
     * Caso Incorrecto
     */
    @Test(expected = java.lang.AssertionError.class)
    public void testCambiarYCasoIncorrecto() throws java.lang.AssertionError{
        cuantomemuevo = 20;
        System.out.println("CambiarY");
        misil.y = 9;
        misil.CambiarY(cuantomemuevo);
        assertEquals(29, misil.getPosY(),0);
    }
    /**
     * Test del metodo setInicPos de la clase Misil.
     * Test en el eje x
     */
    @Test
    public void testposicionxSetInitPos(){
        System.out.println("setInitPos");
        misil.setInitPos();
        assertEquals(misilInic.getPosX(), misil.getPosX(),0);
    }
    /**
     * Test del metodo setInicPos de la clase Misil.
     * Test en el eje y
     */
    @Test
    public void testposicionYSetInitPos(){
        System.out.println("setInitPos");
        misil.setInitPos();
        assertEquals(misilInic.getPosY(), misil.getPosY(),0);
    }    
}
