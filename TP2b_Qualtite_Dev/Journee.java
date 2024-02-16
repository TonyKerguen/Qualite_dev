import java.util.List;

public class Journee {
    private Style epreuveMatin;
    private int nbspectateurMatin;
    private Style epreuveApresMidi;
    private int nbspectateurApresMidi;
    private Style epreuveSoiree;
    private int nbspectateurSoiree;
    private List<Auteur> listeParticipant;

    public Journee(Style epreuveMatin, int nbspectateurMatin, Style epreuveApresMidi, int nbspectateurApresMidi, Style epreuveSoiree, int nbspectateurSoiree, List<Auteur> listeParticipant) {
        this.epreuveMatin = epreuveMatin;
        this.nbspectateurMatin = nbspectateurMatin;
        this.epreuveApresMidi = epreuveApresMidi;
        this.nbspectateurApresMidi = nbspectateurApresMidi;
        this.epreuveSoiree = epreuveSoiree;
        this.nbspectateurSoiree = nbspectateurSoiree;
        this.listeParticipant = listeParticipant;
    }

    public Journee(Style epreuveMatin, Style epreuveApresMidi, Style epreuveSoiree, List<Auteur> listeParticipant) {
        this.epreuveMatin = epreuveMatin;
        this.nbspectateurMatin = 0;
        this.epreuveApresMidi = epreuveApresMidi;
        this.nbspectateurApresMidi = 0;
        this.epreuveSoiree = epreuveSoiree;
        this.nbspectateurSoiree = 0;
        this.listeParticipant = listeParticipant;
    }

    public int scoreJournee() {
        int score = 0;
        for(Auteur a : this.listeParticipant) {
            score += a.qualiteStyle(epreuveMatin)*nbspectateurMatin;
            score += a.qualiteStyle(epreuveApresMidi)*nbspectateurApresMidi;
            score += a.qualiteStyle(epreuveSoiree)*nbspectateurSoiree;
        }
        return score;
    }

    public int nbAplaudissement(Auteur a) {
        return  a.qualiteStyle(epreuveMatin)*nbspectateurMatin+
                a.qualiteStyle(epreuveApresMidi)*nbspectateurApresMidi+
                a.qualiteStyle(epreuveSoiree)*nbspectateurSoiree;
    }

    public int gagantJournee() {
        if(this.listeParticipant.get(0).qualiteStyle(epreuveMatin)*nbspectateurMatin+
            this.listeParticipant.get(0).qualiteStyle(epreuveApresMidi)*nbspectateurApresMidi+
            this.listeParticipant.get(0).qualiteStyle(epreuveSoiree)*nbspectateurSoiree >
           this.listeParticipant.get(1).qualiteStyle(epreuveMatin)*nbspectateurMatin+
            this.listeParticipant.get(1).qualiteStyle(epreuveApresMidi)*nbspectateurApresMidi+
            this.listeParticipant.get(1).qualiteStyle(epreuveSoiree)*nbspectateurSoiree){
                return 0;
        }
        else {
            return 1;
        }
        
    }
}
