/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.archive.business;

import fr.miage.millan.presse.archive.entities.ArticleBD;
import fr.miage.millan.presse.archive.entities.PubliciteBD;
import fr.miage.millan.presse.archive.entities.TitreBD;
import fr.miage.millan.presse.archive.entities.VolumeBD;
import fr.miage.millan.presse.sharedpubpresse.objects.Publicite;
import fr.miage.millan.presse.sharedredactionpresse.objects.Article;
import fr.miage.millan.presse.sharedvolume.objects.Titre;
import fr.miage.millan.presse.sharedvolume.objects.Volume;
import java.util.ArrayList;

/**
 * Classe permetant
 *
 * @author aympa
 */
public final class GestionEntity {

    public static TitreBD genererTitreBD(Titre titre) {
        TitreBD titreBD = new TitreBD();
        titreBD.setNom(titre.getNom());

        ArrayList<VolumeBD> volumes = new ArrayList<>();

        for (Volume v : titre.getListeVolumes()) {
            volumes.add(genererVolumeBD(v));

        }
        titreBD.setListeVolumes(volumes);

        return titreBD;
    }

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
        ArrayList<ArticleBD> articles = new ArrayList<>();
        ArrayList<PubliciteBD> pubs = new ArrayList<>();

        for (Publicite p : v.getListePublicites()) {
            pubs.add(genererPubBD(p));
        }

        for (Article a : v.getListeArticles()) {
            articles.add(genererArticleBD(a));
        }

        volBD.setListePublicites(pubs);
        volBD.setListeArticles(articles);
        volBD.setNumero(v.getNumero());

        return volBD;
    }

    public static ArrayList<Titre> genererTitres(ArrayList<TitreBD> titresBD) {
        ArrayList<Titre> titres = new ArrayList<>();

        for (TitreBD tbd : titresBD) {
            titres.add(genererTitre(tbd));
        }

        return titres;
    }

    public static Titre genererTitre(TitreBD tbd) {
        Titre titre = new Titre();

        titre.setId(tbd.getId().intValue());
        titre.setNom(tbd.getNom());

        ArrayList<Volume> volumes = new ArrayList<>();

        for (VolumeBD vbd : tbd.getListeVolumes()) {
            volumes.add(genererVolume(vbd));
        }

        titre.setListeVolumes(volumes);

        return titre;
    }

    private static Volume genererVolume(VolumeBD vbd) {
        Volume volume = new Volume();
        volume.setId(vbd.getId().intValue());
        volume.setNumero(vbd.getNumero());

        ArrayList<Article> articles = new ArrayList<>();
        for (ArticleBD abd : vbd.getListeArticles()) {
            articles.add(genererArticle(abd));
        }

        volume.setListeArticles(articles);

        ArrayList<Publicite> pubs = new ArrayList<>();
        for (PubliciteBD pbd : vbd.getListePublicites()) {
            pubs.add(genererPub(pbd));
        }
        
        volume.setListePublicites(pubs);

        return volume;
    }

    private static Article genererArticle(ArticleBD abd) {
        Article art = new Article("", "");
        
        art.setAuteur(abd.getAuteur());
        art.setContenu(abd.getContenu());
        art.setId(abd.getId().intValue());
        art.setMotClefs(abd.getMotsClefs());
        art.setNom(abd.getNom());
        
        return art;
    }

    private static Publicite genererPub(PubliciteBD pbd) {
        Publicite pub = new Publicite(pbd.getNom(), pbd.getContenu());
        pub.setIdPub(pbd.getIdpublicite());
        
        return pub;
    }

}
