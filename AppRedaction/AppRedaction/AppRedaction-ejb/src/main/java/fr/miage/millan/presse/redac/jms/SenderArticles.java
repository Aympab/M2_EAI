/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.redac.jms;

import fr.miage.millan.presse.sharedredactionpresse.objects.Article;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
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
public class SenderArticles {

    private Message createJMSMessageForARTICLE_INIT(Session session, Object messageData) throws JMSException {
        // TODO create and populate message to send
        ObjectMessage om = session.createObjectMessage((ArrayList<Article>)messageData);
        return om;
    }

    public void sendJMSMessageToARTICLE_INIT(Object messageData) throws JMSException, NamingException {
        Context c = new InitialContext();
        ConnectionFactory cf = (ConnectionFactory) c.lookup("CONNECTION_FACTORY_M2_EAI");
        Connection conn = null;
        Session s = null;
        try {
            conn = cf.createConnection();
            s = conn.createSession(false, s.AUTO_ACKNOWLEDGE);
            Destination destination = (Destination) c.lookup("ARTICLE_INIT");
            MessageProducer mp = s.createProducer(destination);
            mp.send(createJMSMessageForARTICLE_INIT(s, messageData));
        } finally {
            if (s != null) {
                try {
                    s.close();
                } catch (JMSException e) {
                    Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot close session", e);
                }
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
    
}
