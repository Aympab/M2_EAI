package fr.miage.millan.presse.archive.entities;

import fr.miage.millan.presse.archive.entities.ArticleBD;
import fr.miage.millan.presse.archive.entities.PubliciteBD;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-11-20T17:48:41")
@StaticMetamodel(VolumeBD.class)
public class VolumeBD_ { 

    public static volatile SingularAttribute<VolumeBD, Integer> numero;
    public static volatile ListAttribute<VolumeBD, PubliciteBD> listePublicites;
    public static volatile ListAttribute<VolumeBD, ArticleBD> listeArticles;
    public static volatile SingularAttribute<VolumeBD, Long> id;

}