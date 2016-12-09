

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ListaTareasTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ListaTareasTest
{
    private ListaTareas listaTar1;

    /**
     * Default constructor for test class ListaTareasTest
     */
    public ListaTareasTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        listaTar1 = new ListaTareas();
        listaTar1.annadirTarea("Hacer la cama");
        listaTar1.annadirTarea("Comprar el pan");
        listaTar1.annadirTarea("Estudiar programacion ");
        listaTar1.annadirTarea("Dormir");
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
