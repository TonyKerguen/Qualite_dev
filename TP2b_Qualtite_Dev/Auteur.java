
public class Auteur {
    private String nom;
    private int performanceTragedie;
    private String tragedie;
    private int performanceComedie;
    private String comedie;
    private int performanceDrame;
    private String drame;

    public Auteur(String nom, int performanceTragedie, String tragedie, int performanceComedie, String comedie, int performanceDrame, String drame) {
        this.nom = nom;
        this.performanceTragedie = performanceTragedie;
        this.tragedie = tragedie;
        this.performanceComedie = performanceComedie;
        this.comedie = comedie;
        this.performanceDrame = performanceDrame;
        this.drame = drame;
    }

    public int getQualiteTragedie() {
        return this.performanceTragedie;
    }

    public String getCitationTragedie() {
        return this.tragedie;
    }

    public int getQualiteComedie() {
        return this.performanceComedie;
    }

    public String getCitationComedie() {
        return this.comedie;
    }

    public int getQualiteDrame() {
        return this.performanceDrame;
    }

    public String getCitationDrame() {
        return this.drame;
    }

    public Style meilleurStyle() {
        if(getQualiteComedie() > getQualiteDrame() && getQualiteComedie() > getQualiteTragedie() ){
            return Style.COMÉDIE;
        }
        else if(getQualiteTragedie() > getQualiteDrame() && getQualiteTragedie() > getQualiteComedie() ){
            return Style.TRAGÉDIE;
        }
        else if (getQualiteDrame() > getQualiteComedie() && getQualiteDrame() > getQualiteTragedie() ) {
            return Style.DRAME;
        }
        return null;
    }

    public int qualiteStyle(Style s) {
        if(s == Style.COMÉDIE) {
            return this.getQualiteComedie();
        }
        else if(s == Style.TRAGÉDIE) {
            return this.getQualiteTragedie();
        }
        else if(s == Style.DRAME) {
            return this.getQualiteDrame();
        }
        return 0;
    }

    public String citationStyle(Style s) {
        if(s == Style.COMÉDIE) {
            return this.getCitationComedie();
        }
        else if(s == Style.TRAGÉDIE) {
            return this.getCitationTragedie();
        }
        else if(s == Style.DRAME) {
            return this.getCitationDrame();
        }
        return null;
    }

    @Override
    public String toString(){
        return "L'honorable" + this.nom;
    }
}
