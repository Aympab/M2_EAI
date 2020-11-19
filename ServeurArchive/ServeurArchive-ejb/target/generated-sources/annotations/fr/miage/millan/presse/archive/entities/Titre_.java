package fr.miage.millan.presse.archive.entities;

import fr.miage.millan.presse.archive.entities.Volume;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-11-19T15:21:35")
@StaticMetamodel(Titre.class)
public class Titre_ { 

    public static volatile ListAttribute<TitreBD, Volume> listeVolumes;
    public static volatile SingularAttribute<TitreBD, Long> id;
    public static volatile SingularAttribute<TitreBD, String> nom;

}