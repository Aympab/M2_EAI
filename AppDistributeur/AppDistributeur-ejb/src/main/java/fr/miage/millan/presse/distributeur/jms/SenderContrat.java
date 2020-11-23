/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.distributeur.jms;

import fr.miage.millan.presse.shareddistributeurs.objs.ContratDistributeur;
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
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author aympa
 */
public class SenderContrat {

    private Message createJMSMessageForTRANSFERT_CONTRAT(Session session, Object messageData) throws JMSException {
        ObjectMessage om = session.createObjectMessage((ContratDistributeur)messageData);
        return om;
    }

    public void sendJMSMessageToTRANSFERT_CONTRAT(Object messageData) throws JMSException, NamingException {
        Context c = new InitialContext();
        ConnectionFactory cf = (ConnectionFactory) c.lookup("CONNECTION_FACTORY_M2_EAI");
        Connection conn = null;
        Session s = null;
        try {
            conn = cf.createConnection();
            s = conn.createSession(false, s.AUTO_ACKNOWLEDGE);
            Destination destination = (Destination) c.lookup("TRANSFERT_CONTRAT");
            MessageProducer mp = s.createProducer(destination);
            mp.send(createJMSMessageForTRANSFERT_CONTRAT(s, messageData));
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
