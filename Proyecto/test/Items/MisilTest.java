
package Items;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 *Test de Clase Misil
 * @author Joaquin Avalos
 * @author Matias Medina
 */
public class MisilTest {
    private int cuantomemuevo;
    private Misil misil;
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
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of CambiarY method, of class Misil.
     */
    @Test
    public void testCambiarYCasoCorrecto() {
        cuantomemuevo = 20;
        System.out.println("CambiarY");
        misil.setLocation(100, 300);
        misil.CambiarY(cuantomemuevo);
        assertEquals(320, 300 + cuantomemuevo);
        fail("Fallo en CambiarY");
    }
        @Test
    public void testCambiarYCasoLimite() {
        cuantomemuevo = 20;
        System.out.println("CambiarY");
        misil.setLocation(100, 326);
        misil.CambiarY(cuantomemuevo);
        assertEquals(316, 326 + cuantomemuevo);
        fail("Fallo en CambiarY");
    }
    public void testCambiarYCasoLimite2() {
        cuantomemuevo = 20;
        System.out.println("CambiarY");
        misil.setLocation(100, 35);
        misil.CambiarY(cuantomemuevo);
        assertEquals(45, 35 + cuantomemuevo);
        fail("Fallo en CambiarY");
    }
    
    /**
     * Test of getVelocidad method, of class Misil.
     */
    @Test
    public void testGetVelocidad() {
        System.out.println("getVelocidad");
        Misil instance = null;
        float expResult = 0.0F;
        float result = instance.getVelocidad();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVelocidad method, of class Misil.
     */
    @Test
    public void testSetVelocidad() {
        System.out.println("setVelocidad");
        float v = 0.0F;
        Misil instance = null;
        instance.setVelocidad(v);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDireccion method, of class Misil.
     */
    @Test
    public void testSetDireccion() {
        System.out.println("setDireccion");
        float d = 0.0F;
        Misil instance = null;
        instance.setDireccion(d);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Lanzamiento method, of class Misil.
     */
    @Test
    public void testLanzamiento() {
        System.out.println("Lanzamiento");
        boolean l = false;
        Misil instance = null;
        instance.Lanzamiento(l);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Reset method, of class Misil.
     */
    @Test
    public void testReset() {
        System.out.println("Reset");
        Misil instance = null;
        instance.Reset();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkearObjetivo method, of class Misil.
     */
    @Test
    public void testCheckearObjetivo() {
        System.out.println("checkearObjectivo");
        Misil instance = null;
        boolean expResult = false;
        boolean result = instance.checkearObjetivo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of girar method, of class Misil.
     */
    @Test
    public void testGirar() {
        System.out.println("girar");
        Misil instance = null;
        instance.girar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mover method, of class Misil.
     */
    @Test
    public void testMover() {
        System.out.println("mover");
        misil.mover();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Colision method, of class Misil.
     */
    @Test
    public void testColision() {
        System.out.println("Colision");
        Misil instance = null;
        instance.Colision();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColision method, of class Misil.
     */
    @Test
    public void testGetColision() {
        System.out.println("getColision");
        Misil instance = null;
        boolean expResult = false;
        boolean result = instance.getColision();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
