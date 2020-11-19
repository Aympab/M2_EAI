package fr.miage.millan.presse.redac.services;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import fr.miage.millan.presse.sharedredactionpresse.objects.Article;
import java.util.ArrayList;
import javax.ejb.Stateless;
import java.util.Iterator;

/**
 *
 * @author aympa
 */
@Stateless
public class ServiceRedaction implements ServiceRedactionLocal {

    //Id a incrémenter à chaque création
    private static long idCreation = 1;
    private static final ArrayList<Article> articlesAEnvoyer = new ArrayList<Article>();
    private static final ArrayList<Article> bdArticle = new ArrayList<Article>();

    @Override
    public void creerArticle(String nomArticle, ArrayList<String> motClefs, String contenu, String auteur) {
        Article art = new Article(nomArticle, motClefs, contenu, auteur);
        art.setId(idCreation);

        bdArticle.add(art);

        ServiceRedaction.idCreation++;
    }

    @Override
    public ArrayList<Article> selectionnerArticles(Long idArticleSelectionne) {
        Article art;

        Iterator ite = bdArticle.iterator();
        while (ite.hasNext()) {
            art = (Article) ite.next();
            if (art.getId() == idArticleSelectionne) {
                articlesAEnvoyer.add(art);
                break;
            }
        }
        return articlesAEnvoyer;
    }

    @Override
    public void envoyerListeArticles() {

    }

    @Override
    public ArrayList<Article> getAllArticles() {
        return ServiceRedaction.bdArticle;
    }

    public ServiceRedaction() {
        //Création de faux articles pour tester
        genererDonnees();
    }

    @Override
    public void traiterNotification() {
        System.out.println("APPREDACTION_SERVICE REDAC - NOTIF RECUE");
        //Faire le traitement de la notif recue
    }

    private void genererDonnees() {
        ArrayList<String> motsClefs = new ArrayList<>();
        motsClefs.add("cool");
        motsClefs.add("politique");

        creerArticle("ArticleTITLE", motsClefs, "Le CONTENU DE LARTICLE", "AuteurDELARTICLE");

        motsClefs = new ArrayList<>();
        motsClefs.add("Avion");
        motsClefs.add("Bateau");
        creerArticle("ArticleTITLE", motsClefs, "Le CONTENU DU DEUXIEME ARTICLE", "AuteurDU DEUXIEME ARTICLE");
    }

}
