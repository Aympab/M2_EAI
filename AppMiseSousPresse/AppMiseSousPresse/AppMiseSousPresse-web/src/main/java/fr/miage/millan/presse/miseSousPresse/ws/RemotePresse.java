/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.miseSousPresse.ws;

import fr.miage.millan.presse.miseSousPresse.services.ServicePresseLocal;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author aympa
 */
@WebService(serviceName = "RemotePresse")
public class RemotePresse {

    @EJB
    private ServicePresseLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

//    @WebMethod(operationName = "traiterArticles")
//    @Oneway
//    public void traiterArticles(@WebParam(name = "listeArt") ArrayList<fr.miage.millan.presse.sharedredactionpresse.objects.Article> listeArt) {
//        ejbRef.traiterArticles(listeArt);
//    }

    @WebMethod(operationName = "notifierAppRedac")
    @Oneway
    public void notifierAppRedac() {
        ejbRef.notifierAppRedac();
    }
    
    @WebMethod(operationName = "printAllStock")
    @Oneway
    public void printAllStock() {
        ejbRef.printAllStock();
    }
    
}
