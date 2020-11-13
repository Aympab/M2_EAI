/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan;

import fr.miage.millan.services.ServicePresseLocal;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;

/**
 *
 * @author aympa
 */
@WebService(serviceName = "ClientWebAppMiseSousPresse")
@Stateless()
public class ClientWebAppMiseSousPresse {

    @EJB
    private ServicePresseLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "testReceiver")
    @Oneway
    public void testReceiver() {
        ejbRef.testReceiver();
    }
    
}
