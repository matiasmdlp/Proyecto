
package Items;

import java.awt.Graphics;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Clase de Test para la clase Avion.
 *
 * @author Joaquin Avalos
 * @author Matias Medina
 */
public class AvionTest {
    private Avion avion;
    private Avion avionInic;
    public AvionTest() {
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
        avionInic = new Avion();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setInitPos method, of class Avion.
     */
    @Test
    public void testSetInitPos() {
        System.out.println("setInitPos");
        avion.setInitPos();
        assertEquals(avionInic.getPosY(), avion.getPosY(),0);
    }

    /**
     * Test del metodo CambiarY de la clase Avion.
     * Caso Correcto
     */
    @Test
    public void testCambiarYCasoCorrecto() {
        System.out.println("CambiarY");
        avion.y = 200;
        avion.CambiarY(20);
        assertEquals(220, avion.getPosY(),0);
    }
    /**
     * Test del metodo CambiarY de la clase Avion.
     * Caso Limite 1
     */
    @Test
    public void testCambiarYCasoLimite() {
        System.out.println("CambiarY");
        avion.y = 10;
        avion.CambiarY(20);
        assertEquals(20, avion.getPosY(),0);
    }
    /**
     * Test del metodo CambiarY de la clase Avion.
     * Caso Limite 2
     */
    @Test
    public void testCambiarYCasoLimite2() {
        System.out.println("CambiarY");
        avion.y = 300;
        avion.CambiarY(20);
        assertEquals(290, avion.getPosY(),0);
    } 
    /**
     * Test del metodo CambiarY de la clase Avion.
     * Caso Incorrecto
     */
    @Test(expected = java.lang.AssertionError.class)
    public void testCambiarYCasoIncorrecto() throws java.lang.AssertionError{
        System.out.println("CambiarY");
        avion.y = 300;
        avion.CambiarY(20);
        assertEquals(320, avion.getPosY(),0);
    }
    
}
