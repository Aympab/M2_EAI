/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.archive.business;

import fr.miage.millan.presse.archive.entities.ArticleBD;
import fr.miage.millan.presse.archive.entities.PubliciteBD;
import fr.miage.millan.presse.archive.entities.VolumeBD;
import fr.miage.millan.presse.sharedpubpresse.objects.Publicite;
import fr.miage.millan.presse.sharedredactionpresse.objects.Article;
import fr.miage.millan.presse.sharedvolume.objects.Volume;
import java.util.ArrayList;

/**
 * Classe permetant
 *
 * @author aympa
 */
public final class GestionEntity {

    public static PubliciteBD genererPubBD(Publicite pub) {
        PubliciteBD pubBD = new PubliciteBD();

        pubBD.setContenu(pub.getContenu());
        pubBD.setNom(pub.getNom());

        return pubBD;
    }

    public static ArticleBD genererArticleBD(Article art) {
        ArticleBD artBD = new ArticleBD();

        artBD.setAuteur(art.getAuteur());
        artBD.setContenu(art.getContenu());
        artBD.setMotsClefs(art.getMotClefs());
        artBD.setNom(art.getNom());

        return artBD;
    }

    public static VolumeBD genererVolumeBD(Volume v) {
        VolumeBD volBD = new VolumeBD();
        ArrayList<ArticleBD> articles = new ArrayList<ArticleBD>();
        ArrayList<PubliciteBD> pubs = new ArrayList<PubliciteBD>();

        for (Publicite p : v.getListePublicites()) {
            pubs.add(genererPubBD(p));
        }
        
        for(Article a : v.getListeArticles()){
            articles.add(genererArticleBD(a));
        }
        
        volBD.setListePublicites(pubs);
        volBD.setListeArticles(articles);
        volBD.setNumero(v.getNumero());

        return volBD;
    }
}
