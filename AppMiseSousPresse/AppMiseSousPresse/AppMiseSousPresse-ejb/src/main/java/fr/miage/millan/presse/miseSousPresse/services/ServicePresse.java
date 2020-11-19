/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.miseSousPresse.services;

import fr.miage.millan.presse.miseSousPresse.jms.SenderNotification;
import fr.miage.millan.presse.sharedpubpresse.objects.Publicite;
import fr.miage.millan.presse.sharedredactionpresse.objects.Article;
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

//    @Resource(mappedName = "ARTICLE_INITFactory")
//    private ConnectionFactory aRTICLE_INITFactory;
    private final SenderNotification sender = new SenderNotification();

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

    @Override
    public void traiterArticles(ArrayList<Article> listeArt) {
        for (Article a : listeArt) {
            System.out.println("APP PRESSE - CONTENU ARTICLE : " + a.getContenu());
        }
    }

    @Override
    public void recupererPub(ArrayList<Publicite> listePub) {
        for (Publicite a : listePub) {
            System.out.println("APP PRESSE - CONTENU PUB : " + a.getNom() + " - " + a.getContenu() );
        }
    }

}