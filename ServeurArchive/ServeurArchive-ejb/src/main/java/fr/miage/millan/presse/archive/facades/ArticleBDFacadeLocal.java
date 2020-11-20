/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.archive.facades;

import fr.miage.millan.presse.archive.entities.ArticleBD;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author aympa
 */
@Local
public interface ArticleBDFacadeLocal {

    void create(ArticleBD articleBD);

    void edit(ArticleBD articleBD);

    void remove(ArticleBD articleBD);

    ArticleBD find(Object id);

    List<ArticleBD> findAll();

    List<ArticleBD> findRange(int[] range);

    int count();
    
}
