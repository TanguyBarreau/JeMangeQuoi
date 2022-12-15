package com.example.jemangequoi.model;

import android.util.Log;

import com.example.jemangequoi.constantes.restrictionsRecette;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LivreRecettes {

    private List<Recette> livreRecettes;

    public LivreRecettes() {
        this.livreRecettes = creerLivreRecettes();
    }

    public String getRecettes(String typePlat, String aliment1, String aliment2, String aliment3, String restriction) {

        String recettes = "";

        Log.i("TAG", "JMQ restriction " + restriction);

        //NECESSAIRE CE IF ?
        //si le type de plat de la recherche est secret : ne retourne aucune recette
        //if (typePlat.equalsIgnoreCase("secret")) {
        //    return recettes;
        //}
        //==> plutot faire un check à chaque ajout dans un resultat sur le type de plat et si
        //secret alors non ?

        //si pas de type de plat dans la recherche : retourne toutes les recettes sauf secrètes
        if (typePlat.isEmpty()) {
            for (Recette recette : livreRecettes) {
                //if (!recette.getTypeRecette().equalsIgnoreCase("secret")) {
                Log.i("TAG", "JMQ restriction recette " + recette.getRestrictions());
                if (restriction.equalsIgnoreCase(restrictionsRecette.PAS_DE_RESTRICTION) || recette.getRestrictions().contains(restriction)) {
                    recettes = ajouterResultatsDansRecettes(recettes, recette.getNomRecette());
                }
                //}
            }
            return recettes;
        }

        for (Recette recette : livreRecettes) {
            //si le type de plat de la recherche est secret : vérifie que tous les ingrédients
            //sont correctements présents et retourne la recette correspondante
            /*
            if (recette.getTypeRecette().equalsIgnoreCase("secret")) {
                int compteur = 0;
                for (String aliment : recette.getAlimentsRecette()) {
                    if (aliment.equalsIgnoreCase(aliment1) || aliment.equalsIgnoreCase(aliment2) || aliment.equalsIgnoreCase(aliment3)) {
                        compteur += 1;
                    }
                }
                if (compteur == recette.getAlimentsRecette().size()) {
                    recettes = ajouterResultatsDansRecettes(recettes, recette.getNomRecette());
                    return recettes;
                }
            }
            */
            if (recette.getTypeRecette().contains(typePlat) && (restriction.equalsIgnoreCase(restrictionsRecette.PAS_DE_RESTRICTION) || recette.getRestrictions().contains(restriction))) {
                if (!aliment3.isEmpty() && !aliment2.isEmpty() && !aliment1.isEmpty()) {
                    if (recette.getAlimentsRecette().contains(aliment1) && recette.getAlimentsRecette().contains(aliment2) && recette.getAlimentsRecette().contains(aliment3)) {
                        recettes = ajouterResultatsDansRecettes(recettes, recette.getNomRecette());
                    }
                } else if (!aliment2.isEmpty() && !aliment1.isEmpty()) {
                    if (recette.getAlimentsRecette().contains(aliment1) && recette.getAlimentsRecette().contains(aliment2)) {
                        recettes = ajouterResultatsDansRecettes(recettes, recette.getNomRecette());
                    }
                } else if (!aliment1.isEmpty()) {
                    if (recette.getAlimentsRecette().contains(aliment1)) {
                        recettes = ajouterResultatsDansRecettes(recettes, recette.getNomRecette());
                    }
                } else {
                    recettes = ajouterResultatsDansRecettes(recettes, recette.getNomRecette());
                }
            }
        }
        return recettes;
    }

    private String ajouterResultatsDansRecettes(String recettes, String nomRecetteResultat) {
        if (recettes.isEmpty()) {
            recettes += nomRecetteResultat;
        } else {
            recettes += ", " + nomRecetteResultat;
        }

        return recettes;
    }


    private List<Recette> creerLivreRecettes() {

        Recette macaroniFetaTomates = new Recette(
                "macaroni a la feta et a la tomate",
                "pates",
                Arrays.asList(restrictionsRecette.VEGETARIEN),
                Arrays.asList("macaroni", "feta", "tomates cerises", "herbes"));
        Recette spaghettiBolognaise = new Recette(
                "spaghetti bolognaise",
                "pates",
                Arrays.asList(restrictionsRecette.SANS_LACTOSE),
                Arrays.asList("spaghetti", "sauce bolognaise", "fromage rape"));
        Recette saladeRizThonOeufTomates = new Recette(
                "salade de riz thon oeuf tomates",
                "salade de riz",
                Arrays.asList(restrictionsRecette.SANS_LACTOSE),
                Arrays.asList("riz", "thon", "oeuf", "fromage", "tomates", "mais", "huile d'olive"));
        Recette tagliatellesCarbonara = new Recette(
                "pates carbonara",
                "pates",
                Arrays.asList(restrictionsRecette.PAS_DE_RESTRICTION),
                Arrays.asList("tagliatelles", "crème fraiche", "oeuf", "fromage", "lardons"));
        Recette tagliatellesPouletEpinardsCreme = new Recette(
                "pates au poulet épinards et crème",
                "pates",
                Arrays.asList(restrictionsRecette.PAS_DE_RESTRICTION),
                Arrays.asList("tagliatelles", "crème fraiche", "épinards", "poulet"));
        Recette patesPouletCourgettes = new Recette(
                "pates au poulet et aux courgettes",
                "pates",
                Arrays.asList(restrictionsRecette.SANS_LACTOSE),
                Arrays.asList("penne", "courgettes", "poulet"));
        Recette patesPesto = new Recette(
                "pates au pesto",
                "pates",
                Arrays.asList(restrictionsRecette.SANS_LACTOSE, restrictionsRecette.VEGETARIEN),
                Arrays.asList("penne", "pesto", "fromage rape"));
        Recette coquillettesJambon = new Recette(
                "coquillettes au jambon",
                "pates",
                Arrays.asList(restrictionsRecette.SANS_LACTOSE),
                Arrays.asList("coquillettes", "jambon"));
        Recette saladeLentillesTomatesBetteraveFetaOignonsRouges = new Recette(
                "salade de lentilles tomates betterave feta oignons rouges",
                "salade de lentilles",
                Arrays.asList(restrictionsRecette.VEGETARIEN),
                Arrays.asList("lentilles", "tomates", "betterave", "feta", "oignons rouges", "huile d'olive"));
        Recette saladeHaricotsVertsTomatesBetteraveFetaOeufs = new Recette(
                "salade de haricots verts tomates betterave feta oeufs",
                "salade de harictos verts",
                Arrays.asList(restrictionsRecette.PAS_DE_RESTRICTION),
                Arrays.asList("haricots verts", "tomates", "betterave", "feta", "oeufs", "huile d'olive"));
        Recette quesadillasPouletPoivrons = new Recette(
                "quesadillas au poulet et poivrons",
                "quesadillas",
                Arrays.asList(restrictionsRecette.PAS_DE_RESTRICTION),
                Arrays.asList("tortilla", "poulet", "poivrons", "fromage rapé", "oignons"));
        Recette quesadillasSteakhachePoivrons = new Recette(
                "quesadillas au steak hache et poivrons",
                "quesadillas",
                Arrays.asList(restrictionsRecette.PAS_DE_RESTRICTION),
                Arrays.asList("tortilla", "steak hache", "poivrons", "fromage rapé", "oignons"));
        Recette omeletteChampignons = new Recette(
                "omelette aux champignons",
                "omelette",
                Arrays.asList(restrictionsRecette.SANS_LACTOSE),
                Arrays.asList("oeufs", "champignons", "fromage rapé"));
        Recette avocatTomatesMozzarella = new Recette(
                "avocat tomates mozzarella",
                "salade",
                Arrays.asList(restrictionsRecette.VEGETARIEN),
                Arrays.asList("avocat", "tomates", "mozzarella", "huile d'olive"));
        Recette croqueMonsieur = new Recette(
                "croque monsieur",
                "sandwich",
                Arrays.asList(restrictionsRecette.PAS_DE_RESTRICTION),
                Arrays.asList("pain de mie", "jambon", "fromage rape", "bechamel"));
        Recette taboule = new Recette(
                "taboule",
                "salade de semoule",
                Arrays.asList(restrictionsRecette.SANS_LACTOSE, restrictionsRecette.VEGETARIEN),
                Arrays.asList("semoule", "tomates", "concombre", "raisins secs",  "persil"));
        Recette rizCantonais = new Recette(
                "riz cantonais",
                "riz",
                Arrays.asList(restrictionsRecette.SANS_LACTOSE),
                Arrays.asList("riz", "jambon", "oeuf", "petits pois"));
        Recette chiliConCarne = new Recette(
                "chili con carne",
                "riz",
                Arrays.asList(restrictionsRecette.SANS_LACTOSE),
                Arrays.asList("riz", "steak hache", "haricots rouges", "mais", "sauce tomate"));
        Recette pouletCremeCurryRiz = new Recette(
                "poulet creme curry riz",
                "riz",
                Arrays.asList(),
                Arrays.asList("riz", "poulet", "creme fraiche", "curry"));
        Recette carottesRapeesCurryYaourt = new Recette(
                "carottes rapees curry yaourt raisins secs",
                "salade de carottes",
                Arrays.asList(restrictionsRecette.VEGETARIEN),
                Arrays.asList("carottes rapees", "yaourt", "curry", "raisins secs"));
        Recette fonduePoireaux = new Recette(
                "fondue de poireaux",
                "legumes",
                Arrays.asList(restrictionsRecette.VEGETARIEN),
                Arrays.asList("poireaux", "creme fraiche"));
        Recette tarteMoutardeTomates = new Recette(
                "tarte à la moutarde et aux tomates",
                "tarte ou quiche",
                Arrays.asList(restrictionsRecette.SANS_LACTOSE, restrictionsRecette.VEGETARIEN),
                Arrays.asList("pate brisee", "tomates", "moutarde", "herbes de provence"));
        Recette quicheEpinardsChevre = new Recette(
                "tarte/quiche aux epinards et au chevre",
                "tarte ou quiche",
                Arrays.asList(restrictionsRecette.PAS_DE_RESTRICTION),
                Arrays.asList("pate brisee ou feuilletee", "epinards", "chevre", "oeuf"));
        Recette tianLegumes = new Recette(
                "tian de legumes",
                "legumes",
                Arrays.asList(restrictionsRecette.SANS_LACTOSE, restrictionsRecette.VEGETARIEN),
                Arrays.asList("courgettes", "aubergines", "tomates", "oignons", "herbes de provence"));
        Recette ratatouille = new Recette(
                "ratatouille",
                "legumes",
                Arrays.asList(restrictionsRecette.SANS_LACTOSE, restrictionsRecette.VEGETARIEN),
                Arrays.asList("courgettes", "aubergines", "tomates", "poivrons", "oignons", "thym"));

        List<Recette> listeDeRecettes = new ArrayList<Recette>();
        listeDeRecettes.add(macaroniFetaTomates);
        listeDeRecettes.add(spaghettiBolognaise);
        listeDeRecettes.add(saladeRizThonOeufTomates);
        listeDeRecettes.add(tagliatellesCarbonara);
        listeDeRecettes.add(tagliatellesPouletEpinardsCreme);
        listeDeRecettes.add(patesPouletCourgettes);
        listeDeRecettes.add(patesPesto);
        listeDeRecettes.add(coquillettesJambon);
        listeDeRecettes.add(saladeLentillesTomatesBetteraveFetaOignonsRouges);
        listeDeRecettes.add(saladeHaricotsVertsTomatesBetteraveFetaOeufs);
        listeDeRecettes.add(quesadillasPouletPoivrons);
        listeDeRecettes.add(quesadillasSteakhachePoivrons);
        listeDeRecettes.add(omeletteChampignons);
        listeDeRecettes.add(avocatTomatesMozzarella);
        listeDeRecettes.add(croqueMonsieur);
        listeDeRecettes.add(taboule);
        listeDeRecettes.add(rizCantonais);
        listeDeRecettes.add(chiliConCarne);
        listeDeRecettes.add(pouletCremeCurryRiz);
        listeDeRecettes.add(carottesRapeesCurryYaourt);
        listeDeRecettes.add(fonduePoireaux);
        listeDeRecettes.add(tarteMoutardeTomates);
        listeDeRecettes.add(quicheEpinardsChevre);
        listeDeRecettes.add(tianLegumes);
        listeDeRecettes.add(ratatouille);

        return listeDeRecettes;
    }
}
