/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.distribution.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author aympa
 */
@MessageDriven(mappedName = "DIFFUSION_TITRES", activationConfig = {
//    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "DIFFUSION_TITRES")
//    ,
        @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable")
    ,
        @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "DIFFUSION_TITRES")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class RecepteurTitres implements MessageListener {
    
    
    public RecepteurTitres() {
        
    }
    
    @Override
    public void onMessage(Message message) {
        System.out.println("App diffusion : Diffusion topic recue");
    }
    
}
