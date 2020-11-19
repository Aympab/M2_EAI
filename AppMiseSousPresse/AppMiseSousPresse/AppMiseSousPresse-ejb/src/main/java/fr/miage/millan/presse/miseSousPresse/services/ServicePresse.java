/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.miseSousPresse.services;

import fr.miage.millan.entities.Article;
import java.util.ArrayList;
import javax.ejb.Stateless;
import java.io.Serializable;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    @Override
    public void recupererArticle() {
        Context context = null;
        ConnectionFactory factory = null;
        Connection connection = null;
        String factoryName = "CONNECTION_FACTORY_M2_EAI";
        String destName = "ARTICLE_INIT";
        Destination dest = null;
        int count = 5;
        Session session = null;
        MessageConsumer receiver = null;

        try {
            // create the JNDI initial context
            context = new InitialContext();

            // look up the ConnectionFactory
            factory = (ConnectionFactory) context.lookup(factoryName);

            // look up the Destination
            dest = (Destination) context.lookup(destName);

            // create the connection
            connection = factory.createConnection();

            // create the session
            session = connection.createSession(
                    false, Session.AUTO_ACKNOWLEDGE);

            // create the receiver
            receiver = session.createConsumer(dest);

            // start the connection, to enable message receipt
            connection.start();

            Message message = receiver.receive();
            if (message instanceof ObjectMessage) {
                ObjectMessage object = (ObjectMessage) message;

                //TODO : Changer les dingueries ici
                ArrayList<Article> a = (ArrayList<Article>) object.getObject();
                
                Iterator ite = a.iterator();
                while (ite.hasNext()) {
                    System.out.println(((Article) ite.next()).getContenu());
                }
              
            } else if (message != null) {
                System.out.println("Received non text message");
            }

        } catch (JMSException exception) {
            exception.printStackTrace();
        } catch (NamingException exception) {
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
        }
    }

    @Override
    public void notifierAppRedac() {
        Context context = null;
        ConnectionFactory factory = null;
        Connection connection = null;
        String factoryName = "CONNECTION_FACTORY_M2_EAI";
        String destName = "PRESSE_NOTIF_REDAC";
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
            String notif = "NOTIF_FROM_SERVICE_PRESSE";
            object.setObject((Serializable) notif);
                        
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
        }
    }

}
