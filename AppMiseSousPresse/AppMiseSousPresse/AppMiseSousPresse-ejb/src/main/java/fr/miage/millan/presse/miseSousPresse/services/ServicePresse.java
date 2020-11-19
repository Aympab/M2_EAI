/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.miseSousPresse.services;

import fr.miage.millan.presse.miseSousPresse.jms.SenderNotification;
import fr.miage.millan.presse.sharedredactionpresse.objects.Article;
import java.util.ArrayList;
import javax.ejb.Stateless;
import java.io.Serializable;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.jms.Destination;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.ObjectMessage;
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

            sender.sendJMSMessageToPRESSE_NOTIF_REDAC(new String("NOTIFICATION NOUVEAUX TRUCS"));

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

}
