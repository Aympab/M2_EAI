
import fr.miage.millan.entities.Article;
import fr.miage.millan.services.ServiceRedaction;
import javax.ejb.EJB;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aympa
 */
public class TestMain {

    
    @EJB
    ServiceRedaction service;
    
    /**
     * @param args the command line arguments
     */
    public void main(String[] args) {
        // TODO code application logic here
        Article a = new Article("ArticleCool", "Cool cool cool", "Cool-man");
        
//        ServiceRedaction service = new ServiceRedaction();
        
        service.envoyerArticle(a);
    }
    
}
