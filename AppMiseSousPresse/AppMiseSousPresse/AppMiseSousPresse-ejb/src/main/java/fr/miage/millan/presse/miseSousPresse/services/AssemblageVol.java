/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.miseSousPresse.services;

import fr.miage.millan.presse.miseSousPresse.jms.SenderNotification;
import fr.miage.millan.presse.miseSousPresse.metier.SimulationStockage;
import fr.miage.millan.presse.sharedpubpresse.objects.Publicite;
import fr.miage.millan.presse.sharedredactionpresse.objects.Article;
import fr.miage.millan.presse.sharedvolume.objects.Titre;
import fr.miage.millan.presse.sharedvolume.objects.Volume;
import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 *
 * @author aympa
 */
@Stateless
public class AssemblageVol implements AssemblageVolLocal {

    static SenderNotification senderNotif = new SenderNotification();

    @Override
    public Volume assemblerVolumeSimple(int numeroVolume) throws Exception {

        Volume volume = new Volume();

        if (SimulationStockage.getStockArticle().size() > 0) {
            volume.setListeArticles(SimulationStockage.getStockArticle());
        } else {
            throw new Exception("APPPRESSE - ERREUR AssemblageVol - Pas d'articles en stock pour assembler un volume");
        }

        if (SimulationStockage.getStockPub().size() > 0) {
            volume.setListePublicites(SimulationStockage.getStockPub());
        } else {
            throw new Exception("APPPRESSE - ERREUR AssemblageVol - Pas de publicites en stock pour assembler un volume");
        }

        volume.setNumero(numeroVolume);

        sauvegarderVolume(volume);

        //On envoie la notification à l'app redaction
        senderNotif.sendJMSMessageToPRESSE_NOTIF_REDAC("NOUVEAU VOLUME ASSEMBLE");
        return volume;
    }

    public void sauvegarderVolume(Volume v) {
        SimulationStockage.ajouterVolume(v);
    }

    @Override
    public Volume assemblerVolumeComplexe(int numeroVolume, ArrayList<Integer> listeIdsArticles, ArrayList<Integer> listeIdsPubs) throws Exception {
        Volume volume = new Volume();
        ArrayList<Article> listArticles = SimulationStockage.getStockArticleByListId(listeIdsArticles);
        ArrayList<Publicite> listPubs = SimulationStockage.getStockPubByListIds(listeIdsPubs);

        if (!listArticles.isEmpty()) {
            volume.setListeArticles(listArticles);
        } else {
            throw new Exception("APPPRESSE - ERREUR AssemblageVol - Pas d'articles en stock correspondant a ces identifiants pour assembler un volume");
        }

        if (!listPubs.isEmpty()) {
            volume.setListePublicites(listPubs);
        } else {
            throw new Exception("APPPRESSE - ERREUR AssemblageVol - Pas de publicites en stock correspondant à ces identifiants pour assembler un volume");
        }

        volume.setNumero(numeroVolume);
        sauvegarderVolume(volume);

        //On envoie la notification à l'app redaction
        senderNotif.sendJMSMessageToPRESSE_NOTIF_REDAC("NOUVEAU VOLUME ASSEMBLE");
        return volume;
    }

    @Override
    public Titre assemblerTitreSimple(String nomTitre) throws Exception {
        Titre titre = new Titre();
        titre.setNom(nomTitre);
        titre.setListeVolumes(SimulationStockage.getStockVolume());

        SimulationStockage.ajouterTitre(titre);

        return titre;
    }

}
