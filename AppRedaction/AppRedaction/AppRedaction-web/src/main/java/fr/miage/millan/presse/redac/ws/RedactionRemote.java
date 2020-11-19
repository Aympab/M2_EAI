/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.redac.ws;

import fr.miage.millan.presse.redac.services.ServiceRedactionLocal;
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
@WebService(serviceName = "RedactionRemote")
public class RedactionRemote {

    @EJB
    private ServiceRedactionLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "creerArticle")
    @Oneway
    public void creerArticle(@WebParam(name = "nomArticle") String nomArticle, @WebParam(name = "motClefs") ArrayList<String> motClefs, @WebParam(name = "contenu") String contenu, @WebParam(name = "auteur") String auteur) {
        ejbRef.creerArticle(nomArticle, motClefs, contenu, auteur);
    }

    @WebMethod(operationName = "envoyerListeArticles")
    @Oneway
    public void envoyerListeArticles() {
        ejbRef.envoyerListeArticles();
    }

    @WebMethod(operationName = "selectionnerArticle")
    public ArrayList<fr.miage.millan.presse.sharedredactionpresse.objects.Article> selectionnerArticle(@WebParam(name = "idArticleSelectionne") Long idArticleSelectionne) {
        return ejbRef.selectionnerArticle(idArticleSelectionne);
    }

    @WebMethod(operationName = "getAllArticles")
    public ArrayList<fr.miage.millan.presse.sharedredactionpresse.objects.Article> getAllArticles() {
        return ejbRef.getAllArticles();
    }

//    @WebMethod(operationName = "traiterNotification")
//    @Oneway
//    public void traiterNotification(@WebParam(name = "notif") String notif) {
//        ejbRef.traiterNotification();
//    }
    
}
