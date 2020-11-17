package fr.miage.millan.presse.archive.entities;

import fr.miage.millan.presse.archive.entities.Volume;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-11-17T21:16:46")
@StaticMetamodel(Titre.class)
public class Titre_ { 

    public static volatile ListAttribute<Titre, Volume> listeVolumes;
    public static volatile SingularAttribute<Titre, Long> id;
    public static volatile SingularAttribute<Titre, String> nom;

}