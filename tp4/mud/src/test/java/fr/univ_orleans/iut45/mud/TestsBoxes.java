// import org.junit.*;
// import static org.junit.Assert.assertEquals;
package fr.univ_orleans.iut45.mud;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;

import org.junit.Test;

public class TestsBoxes{
    // @Test
    // public void testBoxCreate() {
    //     Box b = new Box("test");
    // }
    /** on veut pouvoir mettre des trucs dedans 
     * @throws FileNotFoundException */
    // @Test
    // public void testBoxAdd(){
    // Box b = new Box("test");
    // b.add(new Thing("truc1"));
    // b.add(new Thing("truc2"));

    // System.out.println(b.actionLook());
    // public static void main(String[] args) {
    //     Box j = Box.fromJSON();
    // j.add(new Thing("truc1"));

    // System.out.println(j);
    // }

    @Test
    public void testBoxFromJSONSimple() throws FileNotFoundException{
    // use the file test1.json in ressources folder
    String path = TestsBoxes.class.getClassLoader().getResource("boite.json").getFile();
    Box b = Box.fromJSON("/home/iut45/Etudiants/o22205496/home_iut/Qualite_dev/tp4/mud/src/test/resources/boite.json");
    assertEquals(b.getCapacity(), -1);
    assertTrue(b.isOpen());
    }
    
};