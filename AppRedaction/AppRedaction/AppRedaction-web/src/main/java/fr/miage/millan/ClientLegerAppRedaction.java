/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan;

import fr.miage.millan.entities.Article;
import fr.miage.millan.services.ServiceRedactionLocal;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author aympa
 */
@WebService(serviceName = "ClientLegerAppRedaction")
@Stateless()
public class ClientLegerAppRedaction {

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

    @WebMethod(operationName = "selectionnerArticles")
    @Oneway
    public void selectionnerArticles(@WebParam(name = "art") Article art) {
        ejbRef.selectionnerArticles(art);
    }

    @WebMethod(operationName = "getArticles")
    public ArrayList<Article> getArticles() {
        return ejbRef.getArticles();
    }
    
}
