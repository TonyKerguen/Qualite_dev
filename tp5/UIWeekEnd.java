import java.util.ArrayList;
import java.util.List;

public class UIWeekEnd {    
    public static void main(String[] args) {
		Personne pierre = new Personne("Durand","Pierre"); 
		System.out.println(pierre.getNom()); 
		Personne paul = new Personne("Dupond","Paul"); 
		Personne marie = new Personne("Dumond","Marie");
		Personne anne = new Personne("Dunon","Anne");  
		Depense d1 = new Depense(pierre, 12, "pain"); 	
		Depense d2 = new Depense(paul, 100, "pizza"); 
		Depense d3 = new Depense(pierre, 70, "essence");
		Depense d4 = new Depense(marie, 15, "vin");  
		Depense d5 = new Depense(paul, 10, "vin"); 
		WeekEnd we = new WeekEnd();  
		we.ajouterPersonne(pierre); 
		we.ajouterPersonne(paul);
		we.ajouterPersonne(marie);
		we.ajouterPersonne(anne); 
		we.ajouterDepense(d1);   
		we.ajouterDepense(d2); 
		we.ajouterDepense(d4);   
		we.ajouterDepense(d3);
		we.ajouterDepense(d5);
		AppWeekEnd app = new AppWeekEnd(we);
		app.run();
    }
}
    
class AppWeekEnd {
	Personne personne_selectionnee = null;
    WeekEnd we;
    boolean quitter;

    AppWeekEnd(WeekEnd we) {
	this.we = we;
	this.quitter = false;
    }

    public void run() {
		bienvenue();
		boolean continuer = true;
		while(!quitter) {
		    menu();
		}
		au_revoir();
    }

    public void menu() {
		boolean commande_faite = false;
		boolean menu_personne = false;

		List<String> option = new ArrayList<>();
		option.add("Menu principal");
		option.add("Q: Quitter");
		option.add("D: Menu dépenses");
		option.add("P: Menu personnes");
		option.add("T: Total dépenses");
		option.add("M: Moyenne des dépenses");

		while(!commande_faite) {
			creationMenu(option);
		    String commande_brute = System.console().readLine();
		    String commande = commande_brute.strip().toLowerCase();
		    if(commande.equals("q")) {
			quitter = true;
			commande_faite = true;
			}
			else if(commande.equals("p")){
				while (!quitter) {
					menu_personne();
				}
				quitter = false;
			}
			else if(commande.equals("d")){
				while (!quitter) {
					menu_depense();
				}
				quitter = false;
			}
			else if(commande.equals("t")){
				System.out.println("Somme dépensé ce week end : " + we.totalDepenses());
			}
			else if(commande.equals("m")){
				System.out.println("Moyenne des dépenses par personne pour ce week end : " + we.depensesMoyenne());
			}
		    else {
			System.out.println("Commande '" + commande_brute + "' invalide.");
		    }
		}
	}

	public void menu_depense() {
		List<String> menuDepense = new ArrayList<>();
		menuDepense.add("Menu Depenses");
		menuDepense.add("L: Afficher la liste des dépenses");
		menuDepense.add("Q: Quitter");

		creationMenu(menuDepense);

		String commande_brute_menu_depense = System.console().readLine();
	    String commande_menu_depense = commande_brute_menu_depense.strip().toLowerCase();
	    if(commande_menu_depense.equals("q")) {
			quitter = true;
		}
		else if(commande_menu_depense.equals("l")) {
			System.out.println("Liste des dépenses : " + we.getDepenses());
		}
		else {
			System.out.println("Commande '" + commande_brute_menu_depense + "' invalide.");
		}
	}

	public void menu_personne() {
		List<String> menuPersonnes = new ArrayList<>();
		menuPersonnes.add("Menu Personnes");
		menuPersonnes.add("L: Liste des personnes");
		menuPersonnes.add("S: Sélectionné une personne");
		menuPersonnes.add("T: Total dépense de la personne sélectionnée");
		menuPersonnes.add("A: L'avoir de la personne sélectionnée");
		menuPersonnes.add("+: Ajouter une personne au WE");
		menuPersonnes.add("Q: Quitter");
	
		creationMenu(menuPersonnes);

		String commande_brute_menu_personne = System.console().readLine();
	    String commande_menu_personne = commande_brute_menu_personne.strip().toLowerCase();
	    if(commande_menu_personne.equals("q")) {
			quitter = true;
		}
		else if(commande_menu_personne.equals("l")) {
			System.out.println(we.getAmis());
		}
		else if(commande_menu_personne.equals("s")) {
			System.out.println("Sélectionner la personne numéro combien?");
			try {
				int commande_brute_menu_personne_2 = Integer.parseInt(System.console().readLine());
				if(!(commande_brute_menu_personne_2 >= we.getAmis().size())) {
					personne_selectionnee = we.getAmis().get(commande_brute_menu_personne_2);
					System.out.println("Vous avez sélectionné "+we.getAmis().get(commande_brute_menu_personne_2));
				}
				else {
					System.out.println("La liste ne contient pas autant de membre !!");
				}
			} catch (java.lang.NumberFormatException e) {
				System.out.println("Il faut que tu donne un numero zzzz");
			}
		}
		else if(commande_menu_personne.equals("t")) {
			try {
				System.out.println(we.totalDepensesPersonne(personne_selectionnee));
			} catch (NullPointerException e) {
				System.out.println("Il faut selectionner une personne avant !");
			}
		}
		else if(commande_menu_personne.equals("a")) {
			try {
				System.out.println(we.avoirPersonne(personne_selectionnee));
			} catch (NullPointerException e) {
				System.out.println("Il faut selectionner une personne avant !");
			}
		}
		else if(commande_menu_personne.equals("+")) {
			System.out.println("Quel est le nom de la nouvelle personne ?");
			String nom = System.console().readLine();
			System.out.println("Quel est le prenom de la nouvelle personne ?");
			String prenom = System.console().readLine();
			Personne personneAAjouter = new Personne(nom, prenom);
			if(!we.getAmis().contains(personneAAjouter)){
				we.ajouterPersonne(personneAAjouter);
				System.out.println("La personne a bien été ajouter !");
			}
			else {
				System.out.println("La personne n'a pas été ajouter !");
			}
		}
		else {
			System.out.println("Commande '" + commande_brute_menu_personne + "' invalide.");
		}
	}


	public void creationMenu(List<String> l) {
		int plusGrandeChaine = 0;
		for(String s : l) {
			if(s.length() > plusGrandeChaine) {
				plusGrandeChaine = s.length();
			}
		}
		System.out.println("╭─"+"─".repeat(plusGrandeChaine)+"─╮");
		System.out.println("│ "+l.get(0)+" ".repeat(plusGrandeChaine-l.get(0).length())+" │");
		System.out.println("├─"+"─".repeat(plusGrandeChaine)+"─┤");
		for(int i = 1; i <l.size(); i++){
			System.out.println("│ "+l.get(i)+" ".repeat(plusGrandeChaine-l.get(i).length())+" │");
		}
		System.out.println("╰─"+"─".repeat(plusGrandeChaine)+"─╯");
	}

    /// Affiche un message de bienvenue
    public void bienvenue() {
	System.out.println("╭────────────────────────────────────────────────────────────────────────────────────╮");
	System.out.println("│ Bienvenue! En week-end comme dans la semaine, les bons comptes font les bons amis. │");
	System.out.println("╰────────────────────────────────────────────────────────────────────────────────────╯");
    }

    /// Affiche un message d'au revoir
    public void au_revoir() {
		System.out.println("╭──────────────╮");
		System.out.println("│ Au revoir !! │");
		System.out.println("╰──────────────╯");
    }

}

class Personne{
    private String nom;
    private String prenom;
    public Personne( String n, String p) {this.nom = n; this.prenom = p;}
    public String toString() {return this.prenom + " " + this.nom + " ";  }
    public String getNom() {return this.nom;}
    public String getPrenom() {return this.prenom;}

	@Override
	public boolean equals(Object o){
		if(o == this) {
			return true;
		}
		if(!(o instanceof Personne)) {
			return false;
		}
		Personne p = (Personne) o;
		return p.getNom().equals(this.getNom()) && p.getPrenom().equals(this.getPrenom());
	}
}
class Depense{
    private Personne pers;
    private double montant; 
    private String produit;
    public Depense(Personne p, double mont, String prod ){
	this.pers = p; this.montant = mont; this.produit = prod;
    }
    public Personne getPersonne() {return this.pers;}
    public double getMontant() {return this.montant;}
    public String getProduit() {return this.produit;}

	@Override
	public String toString() {
		return this.getProduit() + " : " + this.getMontant() + "€";
	}
}

class WeekEnd{
    private List<Personne> listeAmis;
    private List<Depense> listeDepenses;

    public WeekEnd(){
		this.listeAmis = new ArrayList<>();
		this.listeDepenses = new ArrayList<>();
    }
	
    public List<Personne> getAmis() {
		return this.listeAmis;
    }

    public List<Depense> getDepenses() {
		return this.listeDepenses;
    }
    
    public void ajouterPersonne(Personne p){this.listeAmis.add(p);}
    
	public void ajouterDepense(Depense d){this.listeDepenses.add(d); }
    
	// totalDepensesPersonne prend en entrée une personne et renvoie la somme des depenses de cette personne.
    public double totalDepensesPersonne(Personne p){
		double s = 0.0;
		for(Depense d : this.listeDepenses) {
			if((p.getNom()).equals(d.getPersonne().getNom()))
			s += d.getMontant();
		}
		return s;
    }

    // totalDepenses renvoie la somme de toutes les dépenses. 
    public double totalDepenses(){
		double s = 0.0; 
		for(Depense d : this.listeDepenses) 
			s += d.getMontant();
		return s;
    }

    // depensesMoyenne renvoie la moyenne des dépenses pour une personne 
    public double depensesMoyenne(){
		double s = totalDepenses(); 
		int nb = this.listeAmis.size(); 
		if(nb != 0) 
			return s/nb;
		else 
			return s; 
    }

    //depenseProduit prend en entrée un produit, et renvoie la somme des dépenses pour ce produit. (par exemple du pain peut avoir été acheté plusieurs fois..)
    public double depenseProduit(String p){
		double s = 0.0; 
		for(Depense d : this.listeDepenses) 
			if (p.equals(d.getProduit()))
			s+= d.getMontant();
		return s;
    } 

    // avoirPersonne prend en entrée une personne et renvoie l'avoir de cette personne pour le week end.
    public double avoirPersonne(Personne p){
		double m = depensesMoyenne(); 
		double avoir = m - totalDepensesPersonne(p); 
		return avoir; 
    }
}

class Executable {
    public static void main(String [] args) {
	Personne pierre = new Personne("Durand","Pierre"); 
	System.out.println(pierre.getNom()); 
	Personne paul = new Personne("Dupond","Paul"); 
	Personne marie = new Personne("Dumond","Marie");
	Personne anne = new Personne("Dunon","Anne");  
	Depense d1 = new Depense(pierre, 12, "pain"); 	
	Depense d2 = new Depense(paul, 100, "pizza"); 
	Depense d3 = new Depense(pierre, 70, "essence");
	Depense d4 = new Depense(marie, 15, "vin");  
	Depense d5 = new Depense(paul, 10, "vin"); 
	WeekEnd we = new WeekEnd();  
	we.ajouterPersonne(pierre); 
	we.ajouterPersonne(paul);
	we.ajouterPersonne(marie);
	we.ajouterPersonne(anne); 
	we.ajouterDepense(d1);   
	we.ajouterDepense(d2); 
	we.ajouterDepense(d4);   
	we.ajouterDepense(d3);
	we.ajouterDepense(d5);
	System.out.println("total des dépenses "+we.totalDepenses()) ;
	System.out.println("moyenne des dépenses "+we.depensesMoyenne()) ;
	System.out.println("total des dépenses de Pierre "+ we.totalDepensesPersonne(pierre)) ;
	System.out.println("total des dépenses de Paul "+ we.totalDepensesPersonne(paul)) ;
	System.out.println("total des dépenses de Marie "+ we.totalDepensesPersonne(marie)) ;
	System.out.println("total des dépenses de Anne "+ we.totalDepensesPersonne(anne)) ;
	System.out.println("depenses vin "+we.depenseProduit("vin"));
	System.out.println("avoir de pierre "+we.avoirPersonne(pierre));
	System.out.println("avoir de paul "+we.avoirPersonne(paul));	
	System.out.println("avoir de marie "+we.avoirPersonne(marie));
    }
}
