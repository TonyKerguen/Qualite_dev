import org.junit.*;
import static org.junit.Assert.assertEquals;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class JourneeTest {
    
    Auteur auteur1 = new Auteur("auteur1", 5, "tragedieAuteur1", 3, "comedieAuteur1", 2, "drameAuteur1");
    Auteur auteur2 = new Auteur("auteur2", 10, "tragedieAuteur2", 1, "comedieAuteur2", 3, "drameAuteur2");

    List<Auteur> listeParticipants = new ArrayList<>(Arrays.asList(auteur1, auteur2));

    Journee journeeTest = new Journee(Style.TRAGÉDIE, 1, Style.COMÉDIE, 1, Style.DRAME, 1, listeParticipants);

    @Test
    public void testScoreJournee() {
        assertEquals(journeeTest.scoreJournee(), 24);
    }

    @Test
    public void testNbAplaudissement() {
        assertEquals(journeeTest.nbAplaudissement(auteur1), 10);
        assertEquals(journeeTest.nbAplaudissement(auteur2), 14);
    }

    @Test
    public void testGagantJournee() {
        assertEquals(journeeTest.gagantJournee(), 1);
    }

}
