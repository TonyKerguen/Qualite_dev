import org.junit.*;
import static org.junit.Assert.assertEquals;

import java.beans.Transient;

public class AuteurTest {

    Auteur aristophane = new Auteur("Aristophane", 5, "aa", 100, "", 0, "");

    @Test
    public void testQualiteTragedie() {
        assertEquals(aristophane.getQualiteTragedie(), 5);
    }

    @Test
    public void testgetCitationTragédie() {
        assertEquals(aristophane.getCitationTragedie(), "aa");
    }

    @Test
    public void testmeilleurStyle() {
        assertEquals(aristophane.meilleurStyle(), Style.COMÉDIE);
    }

    @Test
    public void testQualiteStyle() {
        assertEquals(aristophane.qualiteStyle(Style.COMÉDIE), 100);
    }

    @Test
    public void testCitationStyle() {
        assertEquals(aristophane.citationStyle(Style.TRAGÉDIE), "aa");
    }
}
