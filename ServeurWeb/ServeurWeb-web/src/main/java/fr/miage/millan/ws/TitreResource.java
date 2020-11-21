/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.ws;

import com.google.gson.Gson;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author astrid
 */
@Path("titre")
@RequestScoped
public class TitreResource {

    fr.miage.millan.presse.serveurWeb.services.ServiceRechercheLocal serviceRecherche = lookupServiceRechercheLocal();

    @Context
    private UriInfo context;
    
    // Convertisseur JSON
    private Gson gson;

    /**
     * Creates a new instance of TitreResource
     */
    public TitreResource() {
        this.gson = new Gson();
    }

    /**
     * Retrieves representation of an instance of fr.miage.millan.ws.TitreResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJsonTitre() {
        return this.gson.toJson(this.serviceRecherche.getJsonTitre());
    }
    
    @GET
    @Path("{nom}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJsonTitreParNom(@PathParam("nom") String nom) {
        return this.gson.toJson(this.serviceRecherche.getJsonTitreParNom(nom));
    }

    /**
     * PUT method for updating or creating an instance of TitreResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }

    private fr.miage.millan.presse.serveurWeb.services.ServiceRechercheLocal lookupServiceRechercheLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (fr.miage.millan.presse.serveurWeb.services.ServiceRechercheLocal) c.lookup("java:global/ServeurWeb-ear/ServeurWeb-ejb-1.0/ServiceRecherche");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
