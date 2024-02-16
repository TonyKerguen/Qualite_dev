import dionysies.Tournoi;

class Main {
  public static void main(String[] args) {
    String citation_antigone =
        "C'est ainsi que j'irai reposer près de lui, chère à qui m'est cher, saintement"
            + " criminelle.";

    String citation_limiers =
        "Un bruit? Voilà bien de mes froussards! Vous avez peur? Fétides individus, pétris de\n"
            + " pâte à nouilles, la pire faune de couards! La moindre ombre que vous voyez vous\n"
            + " épouvante, vous avez peur de tout! Pas de nerf, pas de tenue, pas francs du\n"
            + " collier! A vous voir, vous n'êtes que des outres, des jacasses et des\n"
            + " viédazes!";

    Auteur sophocle = new Auteur("Sophocle", 95, citation_antigone, 0, "", 60, citation_limiers);

    String citation_hécube =
        "et elle, ayant entendu la parole des maîtres, saisissant ses voiles par l'épaule, les\n"
            + " déchira jusqu'à la hanche, à hauteur du nombril, montra ses seins et son buste,\n"
            + " comme d'une statue, splendide, puis, ayant mis genou en terre, elle tint ce\n"
            + " discours, le plus héroïque en bravoure : \" Voici, jeune homme: si c'est mon"
            + " buste\n"
            + " que tu désires frapper, frappe. Mais si c'est le cou, ma gorge est là, prête, la\n"
            + " voici.\" ";

    String citation_cyclope =
        "La richesse, chétif mortel, est le dieu des sages : tout le reste n'est que vanité et\n"
            + " belles paroles. Que m'importent à moi les promontoires consacrés à mon père? et\n"
            + " pourquoi m'en fais-tu un si pompeux étalage? Étranger, la foudre de Jupiter ne me\n"
            + " fait point trembler ; je ne sais point que Jupiter soit un dieu plus puissant que\n"
            + " moi : au surplus, je ne m'en soucie guère. Et pourquoi je ne m'en soucie pas, le\n"
            + " voici : Si ce dieu verse la pluie du haut du ciel, j'ai sous ce rocher un abri\n"
            + " solide et couvert; j'y mange un veau rôti ou quelque bête sauvage, et j'arrose"
            + " mon\n"
            + " ventre étendu, en vidant une amphore pleine de lait ; et je frappe dessus,\n"
            + " rivalisant, par ce bruit, avec le tonnerre de Jupiter. Et lorsque le Thrace\n"
            + " Borée verse la neige à gros flocons, je couvre mon corps de peaux de bêtes, je"
            + " fais\n"
            + " grand feu, et je me ris de la neige. La terre, de gré ou de force, fait naître de\n"
            + " l'herbe pour engraisser mes troupeaux. Je me garde bien de les immoler à quelque\n"
            + " autre dieu qu'à moi-même et à mon ventre, qui est le plus grand des dieux. Boire"
            + " et\n"
            + " manger chaque jour, et ne s'inquiéter de rien, voilà le Jupiter des sages. Que"
            + " ceux\n"
            + " qui ont établi des lois, et embarrassé la vie humaine de mille soins inutiles,\n"
            + " soient maudits. Je ne cesserai point, pour leur plaire, de me réjouir le cœur, et\n"
            + " je ne t'en croquerai pas moins. Voici donc les dons d'hospitalité que je t'offre,\n"
            + " afin d'être irréprochable devant toi. Un bon feu, et cette marmite de la maison"
            + " de\n"
            + " mes pères, qui te fera bouillir a merveille et le vêtira chaudement. Allons,"
            + " entrez\n"
            + " là-dedans; allez à l'autel du dieu de cette caverne, et préparez-moi un bon"
            + " festin.\n"
            + " ";

    Auteur euripide = new Auteur("Euripide", 92, citation_hécube, 0, "", 80, citation_cyclope);

    String citation_guêpes =
        "TRYGÉE : Tiens, voilà quelqu'un qui s'amène avec une couronne de lauriers sur la tête.\n"
            + "LE SERVITEUR : Qui ça peut-il être ?\n"
            + "TRYGÉE : Il a une tête de charlatan.\n"
            + "LE SERVITEUR : Un devin peut-être ?";

    String citation_thesmophories =
        "La fortune a vite fait de changer en mal et de régner sous une autre face.";

    Auteur aristophane = new Auteur("Aristophane", 5, citation_thesmophories, 100, citation_guêpes, 0, "");

    
  }
}
