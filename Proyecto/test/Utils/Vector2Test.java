
package Utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *Clase de test para Vector2
 * @author Joaquin Avalos
 * @author Matias Medina
 */
public class Vector2Test {
    private Vector2 v1;
    private Vector2 v2;
    public Vector2Test() {

    }
    @Before
    public void setUp() {
        v1 = new Vector2(5,7);
        v2 = new Vector2(12,9);
    }
    @After
    public void tearDown() {
    }

    /**
     * Test del metodo dot, de la clase Vector2.
     */
    @Test
    public void testDot() {
        System.out.println("dot");
        float result = Vector2.dot(v1, v2);
        assertEquals(123, result, 0);
    }

    /**
     * Test del metodo magnitud de la clase Vector2.
     */
    @Test
    public void testMagnitudv1() {
        System.out.println("magnitud");
        float resultado = v1.magnitud();
        assertEquals(8.60, resultado, 0.01);
    }
    @Test
    public void testMagnitudv2() {
        System.out.println("magnitud");
        float resultado = v2.magnitud();
        assertEquals(15, resultado, 0.01);
    }
    
}
