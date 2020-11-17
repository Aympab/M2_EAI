package fr.miage.millan.presse.archive.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-11-17T21:16:46")
@StaticMetamodel(Article.class)
public class Article_ { 

    public static volatile ListAttribute<Article, String> motsClefs;
    public static volatile SingularAttribute<Article, Long> id;
    public static volatile SingularAttribute<Article, String> nom;
    public static volatile SingularAttribute<Article, String> contenu;
    public static volatile SingularAttribute<Article, String> auteur;

}