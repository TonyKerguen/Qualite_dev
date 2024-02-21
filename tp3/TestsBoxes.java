// import org.junit.*;
// import static org.junit.Assert.assertEquals;

public class TestsBoxes{
    // @Test
    // public void testBoxCreate() {
    //     Box b = new Box("test");
    // }
    /** on veut pouvoir mettre des trucs dedans */
    // @Test
    // public void testBoxAdd(){
    // Box b = new Box("test");
    // b.add(new Thing("truc1"));
    // b.add(new Thing("truc2"));

    // System.out.println(b.actionLook());
    public static void main(String[] args) {
        Box j = Box.fromJSON();
    j.add(new Thing("truc1"));

    System.out.println(j);
    }
    
};