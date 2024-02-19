import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.univ_orleans.iut45.mud.*;

/**
 * Unit test for simple App.
 */
public class TestBoxes 
{
    /**
     * Rigorous Test :-)
     */

    @Test
    public void testBoxFromJSONSimple(){
        // use the file test1.json in ressources folder
        String path = TestBoxes.class.getClassLoader().getResource("test1.json").getFile();
        // Box b = Box.fromJSON(path);
        Box b = new Box();
        org.junit.Assert.assertEquals(b.getCapacity(), -1);
        org.junit.Assert.assertTrue(!(b.isOpen()));
    }
}
