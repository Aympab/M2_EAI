/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.miseSousPresse.services;

import fr.miage.millan.presse.miseSousPresse.jms.SenderArchiveTitre;
import fr.miage.millan.presse.miseSousPresse.jms.SenderDistributionVolume;
import fr.miage.millan.presse.miseSousPresse.bd.SimulationStockage;
import fr.miage.millan.presse.miseSousPresse.jms.DiffuseurTitres;
import fr.miage.millan.presse.miseSousPresse.jms.SenderNotification;
import fr.miage.millan.presse.sharedpubpresse.objects.Publicite;
import fr.miage.millan.presse.sharedredactionpresse.objects.Article;
import fr.miage.millan.presse.sharedvolume.objects.Titre;
import fr.miage.millan.presse.sharedvolume.objects.Volume;
import java.util.ArrayList;
import javax.ejb.Stateless;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.naming.NamingException;

/**
 *
 * @author aympa
 */
@Stateless
public class ServicePresse implements ServicePresseLocal {

    @Resource(mappedName = "CONNECTION_FACTORY_M2_EAI")
    private ConnectionFactory CONNECTION_FACTORY_M2_EAI;

//    private static ArrayList<Volume> volumesAEnvoyer = genererDonnees();
    private static ArrayList<Volume> volumesAEnvoyer = new ArrayList<Volume>();
    private static ArrayList<Titre> titresAEnvoyer = new ArrayList<Titre>();

    private final SenderNotification sender = new SenderNotification();
    private final SenderArchiveTitre senderArchive = new SenderArchiveTitre();
    private final SenderDistributionVolume senderDistrib = new SenderDistributionVolume();

    @Override
    public void notifierAppRedac() {
        try {

            sender.sendJMSMessageToPRESSE_NOTIF_REDAC(new String("LE VOLUME + NOM VOLUME + EST TERMINE"));

        } catch (JMSException ex) {
            Logger.getLogger(ServicePresse.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(ServicePresse.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

//    @Override
    public void traiterArticles(ArrayList<Article> listeArt) {
        for (Article a : listeArt) {
            System.out.println("APP PRESSE - ARTICLE ENREGISTRE :\nCONTENU ARTICLE : " + a.getContenu());
            SimulationStockage.ajouterArticle(a);
        }
    }

//    @Override
    public void recupererPub(ArrayList<Publicite> listePub) {
        for (Publicite a : listePub) {
            System.out.println("APP PRESSE - PUB ENREGISTREE :\n" + a.getNom() + " - " + a.getContenu());
            SimulationStockage.ajouterPub(a);
        }
    }

    @Override
    public void printAllStock() {
        System.out.println("APPSOUSPRESSE - PRINT ALL STOCK");
        System.out.println("\n\tPublicites :");

        for (Publicite p : SimulationStockage.getStockPub()) {
            System.out.println("\t\tID : " + p.getIdPub() + "\n\t\t\t" + p.getNom() + " - " + p.getContenu());
        }

        System.out.println("\n\tArticles :");
        for (Article a : SimulationStockage.getStockArticle()) {
            System.out.println("\t\tID : " + a.getId() + "\n\t\t\t" + a.getAuteur() + " - " + a.getNom() + " - " + a.getContenu());
        }

        System.out.println("\n\tVolumes : ");
        for (Volume v : SimulationStockage.getStockVolume()) {
            System.out.println("\t\tID : " + v.getId() + " Numéro : " + v.getNumero());

            System.out.println("\t\t\tArticles : ");
            for (Article a : v.getListeArticles()) {
                System.out.println("\t\t\t\tID : " + a.getId() + "\n\t\t\t\t\t" + a.getAuteur() + " - " + a.getNom() + " - " + a.getContenu());
            }

            System.out.println("\t\t\tPubs : ");
            for (Publicite p : v.getListePublicites()) {
                System.out.println("\t\t\t\tID : " + p.getIdPub() + "\n\t\t\t\t\t" + p.getNom() + " - " + p.getContenu());
            }
        }

        System.out.println("\nAPPSOUSPRESSE - FIN DU STOCK");
    }

    @Override
    public ArrayList<Volume> getVolumesAEnvoyer() {
        return volumesAEnvoyer;
    }

    @Override
    public void transfererVolumesArchive() {
        try {
            senderArchive.sendJMSMessageToPRESSE_TRANSFERT_ARCHIVE(volumesAEnvoyer);
        } catch (JMSException ex) {
            Logger.getLogger(ServicePresse.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(ServicePresse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void transfererVolumesDistribution() {
        try {
            senderDistrib.sendJMSMessageToPRESSE_TRANSFERT_DISTRIB(volumesAEnvoyer);
        } catch (JMSException ex) {
            Logger.getLogger(ServicePresse.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(ServicePresse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Volume> selectionnerVolumePourEnvoi(int idVolume) {
        for (Volume v : SimulationStockage.getStockVolume()) {
            if (v.getId() == idVolume) {
                volumesAEnvoyer.add(v);
                break;
            }
        }
        return volumesAEnvoyer;
    }

    @Override
    public void transfererTitresArchive() {
        try {
            senderArchive.sendJMSMessageToPRESSE_TRANSFERT_ARCHIVE(titresAEnvoyer);
        } catch (JMSException ex) {
            Logger.getLogger(ServicePresse.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(ServicePresse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Titre> selectionnerTitrePourEnvoi(int idTitre) {
        for (Titre t : SimulationStockage.getStockTitre()) {
            if (t.getId() == idTitre) {
                titresAEnvoyer.add(t);
                break;
            }
        }
        return titresAEnvoyer;
    }

    @Override
    public String diffuserTitres() {
        try {
            DiffuseurTitres diffuseur = new DiffuseurTitres();
            diffuseur.sendJMSMessageToDIFFUSION_TITRES(titresAEnvoyer);
            return "OK";
        } catch (JMSException ex) {
            Logger.getLogger(ServicePresse.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(ServicePresse.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "ERROR";
    }

}
