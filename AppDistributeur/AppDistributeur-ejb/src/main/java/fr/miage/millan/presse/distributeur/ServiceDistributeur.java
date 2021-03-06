/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.distributeur;

import fr.miage.millan.presse.distributeur.jms.SenderContrat;
import fr.miage.millan.presse.shareddistributeurs.objs.ContratDistributeur;
import fr.miage.millan.presse.sharedpubpresse.objects.Publicite;
import fr.miage.millan.presse.sharedredactionpresse.objects.Article;
import fr.miage.millan.presse.sharedvolume.objects.Titre;
import fr.miage.millan.presse.sharedvolume.objects.Volume;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.jms.JMSException;
import javax.naming.NamingException;

/**
 *
 * @author aympa
 */
@Stateless
public class ServiceDistributeur implements ServiceDistributeurLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private static final ArrayList<Titre> titresEnStock = new ArrayList<Titre>();
    private static int idTitre = 0;

    public static void ajouterTitreEnStock(Titre t) {
        t.setId(idTitre);
        titresEnStock.add(t);
        idTitre += 1;
    }

    public static void genererTitres() {
        Titre t = new Titre();
        t.setNom("Titre1");
        t.setId(idTitre);
        idTitre += 1;
        titresEnStock.add(t);

        Article a = new Article("ARTICLE 1", "CONTENU ARTICLE 1", "AUTEUR ARTICLE 1");
        String[] motclef = {"mots1", "mots2", "mots3"};
        ArrayList<String> listeMotsClefs = new ArrayList<String>(Arrays.asList(motclef));
        a.setMotClefs(listeMotsClefs);

        Article a2 = new Article("ARTICLE 2", "CONTENU ARTICLE 2", "AUTEUR ARTICLE 2");
        String[] motclef_2 = {"bou1", "bou2", "bou3"};
        ArrayList<String> listeMotsClefs2 = new ArrayList<String>(Arrays.asList(motclef_2));
        a2.setMotClefs(listeMotsClefs2);

        Publicite p = new Publicite("PUBLICITE 1", "CONTENU PUBLICITE 1");
        Publicite p2 = new Publicite("PUBLICITE 2", "CONTENU PUBLICITE 2");

        ArrayList<Article> listeArticles = new ArrayList();
        ArrayList<Publicite> listePublicites = new ArrayList();

        listeArticles.add(a);
        listePublicites.add(p);
        listePublicites.add(p2);

        Volume v = new Volume();
        v.setNumero(1);
        v.setListeArticles(listeArticles);
        v.setListePublicites(listePublicites);

        ArrayList<Article> listeArticles_2 = new ArrayList();
        ArrayList<Publicite> listePublicites_2 = new ArrayList();

        listeArticles_2.add(a);
        listeArticles_2.add(a2);
        listePublicites_2.add(p);

        Volume v2 = new Volume();
        v2.setNumero(1);
        v2.setListeArticles(listeArticles_2);
        v2.setListePublicites(listePublicites_2);

        ArrayList<Volume> listeVolumes = new ArrayList<>();
        listeVolumes.add(v);
        listeVolumes.add(v2);

        t.setListeVolumes(listeVolumes);

        Titre t2 = new Titre();
        t2.setNom("Titre2");
        t2.setId(idTitre);
        idTitre += 1;
        titresEnStock.add(t2);
        t2.setListeVolumes(new ArrayList<Volume>());
    }

    @Override
    public void createAndSendContrat() {
        ContratDistributeur contrat = new ContratDistributeur();
        contrat.setContratValide(true);
        contrat.setCout(130f);
        contrat.setDureeContrat(20);
        contrat.setIdContrat(1);
        contrat.setNbCopies(300);
        contrat.setNomDistrib("Le Monde");
        contrat.setRecepisseValide(true);

        genererTitres();
        contrat.setTitresDiffuses(titresEnStock);

        System.out.println("DISTRIBUTEUR - Contrat créé, envoi du contrat");
        SenderContrat sender = new SenderContrat();
        try {
            sender.sendJMSMessageToTRANSFERT_CONTRAT(contrat);
        } catch (JMSException ex) {
            Logger.getLogger(ServiceDistributeur.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(ServiceDistributeur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
