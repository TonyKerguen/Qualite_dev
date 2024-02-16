import java.util.ArrayList;
import java.util.List;

public class Box {

    private String nomBox;
    private List<Object> contenu;

    public Box(String nomBox) {
        this.nomBox = nomBox;
        this.contenu = new ArrayList<>();
    }

    public String getNom() {
        return this.nomBox;
    }

    public void ajouterContenu(Object o) {
        this.contenu.add(o);
    }

    @Override
    public String toString(){
        return "La boite "+this.getNom()+" contient "+this.contenu.size()+"objet(s)";
    }
}