/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.services;

import fr.miage.millan.entities.Article;
import java.util.ArrayList;
import javax.ejb.Stateless;
import java.io.Serializable;
import java.util.Iterator;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.jms.Destination;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.naming.NamingException;

/**
 *
 * @author aympa
 */
@Stateless
public class ServiceRedaction implements ServiceRedactionLocal {

    //Id a incrémenter à chaque création
    private static long idCreation = 1;
    private static ArrayList<Article> articlesAEnvoyer = new ArrayList<Article>();
    private static ArrayList<Article> bdArticle = new ArrayList<Article>();

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
            art = (Article)ite.next();
            if(art.getId() == idArticleSelectionne){
                articlesAEnvoyer.add(art);
                break;
            }
        }
        return articlesAEnvoyer;
    }

    @Override
    public void envoyerListeArticles() {
        Context context = null;
        ConnectionFactory factory = null;
        Connection connection = null;
        String factoryName = "CONNECTION_FACTORY_M2_EAI";
        String destName = "ARTICLE_INIT";
        Destination dest = null;
        int count = 1;
        Session session = null;
        MessageProducer sender = null;

        try {
            // create the JNDI initial context.
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

            // create the sender
            sender = session.createProducer(dest);

            // start the connection, to enable message sends
            connection.start();

            //TitreBoursier titreBoursier = new TitreBoursier("GOOG", "Google Inc.");
            ObjectMessage object = session.createObjectMessage();
            object.setObject((Serializable) articlesAEnvoyer);
            
//            System.out.println("FROM SERVICE REDAC");
//                Iterator ite = articlesAEnvoyer.iterator();
//                while(ite.hasNext()){
//                    System.out.println(((Article)ite.next()).getContenu());
//                }
            
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
            
            //Vider la liste des trucs à envoyer
            ServiceRedaction.articlesAEnvoyer.clear();
        }
    }

    @Override
    public ArrayList<Article> getArticles() {
        return ServiceRedaction.bdArticle;
    }

    public ServiceRedaction() {
        ArrayList<String> motsClefs = new ArrayList<>();
        motsClefs.add("cool");
        motsClefs.add("politique");

        creerArticle("ArticleTITLE", motsClefs, "Le CONTENU DE LARTICLE", "AuteurDELARTICLE");

        motsClefs = new ArrayList<>();
        motsClefs.add("Avion");
        motsClefs.add("Bateau");
        creerArticle("ArticleTITLE", motsClefs, "Le CONTENU DU DEUXIEME ARTICLE", "AuteurDU DEUXIEME ARTICLE");
    }

    @Override
    public boolean recevoirNotification() {
         Context context = null;
        ConnectionFactory factory = null;
        Connection connection = null;
        String factoryName = "CONNECTION_FACTORY_M2_EAI";
        String destName = "PRESSE_NOTIF_REDAC";
        Destination dest = null;
        int count = 5;
        Session session = null;
        MessageConsumer receiver = null;
        //La valeur de retour
        boolean ret = false;
        
        try {
            context = new InitialContext();
            factory = (ConnectionFactory) context.lookup(factoryName);
            dest = (Destination) context.lookup(destName);
            connection = factory.createConnection();
            session = connection.createSession(
                    false, Session.AUTO_ACKNOWLEDGE);
            receiver = session.createConsumer(dest);
            connection.start();

            Message message = receiver.receive();
            if (message instanceof ObjectMessage) {
                ObjectMessage object = (ObjectMessage) message;

                //TODO : Changer les dingueries ici
                String notif = (String) object.getObject();
                
                if(notif.length() == 0){
                    ret = false;
                }
                else{
                    ret = true;
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
        
        return ret;
    }

}
