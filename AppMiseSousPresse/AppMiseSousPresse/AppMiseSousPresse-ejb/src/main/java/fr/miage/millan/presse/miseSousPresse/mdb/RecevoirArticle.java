/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.miseSousPresse.mdb;

import fr.miage.millan.presse.sharedredactionpresse.objects.Article;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 *
 * @author aympa
 */
@MessageDriven(mappedName = "ARTICLE_INIT", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class RecevoirArticle implements MessageListener {
    
    public RecevoirArticle() {
    }
    
    @Override
    public void onMessage(Message message) {
        if (message instanceof ObjectMessage) {
                ObjectMessage object = (ObjectMessage) message;

            try {
                ArrayList<Article> a = (ArrayList<Article>) object.getObject();
                
//APPEL METIER
            } catch (JMSException ex) {
                Logger.getLogger(RecevoirArticle.class.getName()).log(Level.SEVERE, null, ex);
            }
              
            } else if (message != null) {
                System.out.println("Received non text message");
            }
    }
    
}
