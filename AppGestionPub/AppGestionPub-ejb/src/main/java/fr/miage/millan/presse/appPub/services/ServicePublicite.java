/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.appPub.services;

import fr.miage.millan.presse.appPub.entites.Publicite;
import java.io.Serializable;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author aympa
 */
@Stateless
public class ServicePublicite implements ServicePubliciteLocal {

    public static ArrayList<Publicite> pubsAEnvoyer = new ArrayList<Publicite>();
    
    @Override
    public void creerPublicitePourEnvoi(String nomPub, String contenu) {
        Publicite pub = new Publicite(nomPub, contenu);
        pubsAEnvoyer.add(pub);
    }

    @Override
    public void envoyerPublicites() {
        Context context = null;
        ConnectionFactory factory = null;
        Connection connection = null;
        String factoryName = "CONNECTION_FACTORY_M2_EAI";
        String destName = "PUBINIT";
        Destination dest = null;
        Session session = null;
        MessageProducer sender = null;

        
        try {
            context = new InitialContext();
            factory = (ConnectionFactory) context.lookup(factoryName);
            dest = (Destination) context.lookup(destName);
            connection = factory.createConnection();
            session = connection.createSession(
                    false, Session.AUTO_ACKNOWLEDGE);
            sender = session.createProducer(dest);
            
            connection.start();

            ObjectMessage object = session.createObjectMessage();
            object.setObject((Serializable) pubsAEnvoyer);
                       
            sender.send(object);

        } catch (JMSException | NamingException exception) {
            exception.printStackTrace();
        } finally {
            // close the context
            if (context != null) {
                try {
                    context.close();
                } catch (NamingException exception) {
                    exception.printStackTrace();
                }
            }
            // close the connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException exception) {
                    exception.printStackTrace();
                }
            }
            
            //Vider la liste des pubs à envoyer
            pubsAEnvoyer.clear();
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public ArrayList<Publicite> getListeEnvoi() {
        return pubsAEnvoyer;
    }
}
