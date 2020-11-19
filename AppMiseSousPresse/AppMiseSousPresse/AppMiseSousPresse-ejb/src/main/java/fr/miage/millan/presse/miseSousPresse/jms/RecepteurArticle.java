/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.miseSousPresse.jms;

import fr.miage.millan.presse.miseSousPresse.services.ServicePresse;
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
public class RecepteurArticle implements MessageListener {
    
    ServicePresse metier;
    public RecepteurArticle() {
        metier = new ServicePresse();
    }
    
    @Override
    public void onMessage(Message message) {
        System.out.println("APPPRESSE - OBJ : " + message);
        System.out.println(message.getClass());
        
//        	            Message message = receiver2.receive();
//	            ObjectMessage om = (ObjectMessage) message;
//	            TitreBoursier t = (TitreBoursier) om.getObject();
        if (message instanceof ObjectMessage) {
                ObjectMessage object = (ObjectMessage) message;

            try {
                ArrayList<Article> a = (ArrayList<Article>) object.getObject();
                
                //APPEL METIER                
                metier.traiterArticles(a);

            } catch (JMSException ex) {
                Logger.getLogger(RecepteurArticle.class.getName()).log(Level.SEVERE, null, ex);
            }
              
            } else if (message != null) {
                System.out.println("APPPRESSE - Object type is not ObjectMessage");
            }
    }
    
}
