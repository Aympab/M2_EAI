package fr.miage.millan.presse.archive.entities;

import fr.miage.millan.presse.archive.entities.Article;
import fr.miage.millan.presse.archive.entities.Publicite;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-11-19T15:21:35")
@StaticMetamodel(Volume.class)
public class Volume_ { 

    public static volatile SingularAttribute<Volume, Integer> numero;
    public static volatile ListAttribute<Volume, Publicite> listePublicites;
    public static volatile ListAttribute<Volume, Article> listeArticles;
    public static volatile SingularAttribute<Volume, Long> id;

}