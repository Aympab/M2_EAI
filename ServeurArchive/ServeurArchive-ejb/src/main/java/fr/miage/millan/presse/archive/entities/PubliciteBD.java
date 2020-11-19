/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.archive.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aympa
 */
@Entity
@Table(name = "PUBLICITE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Publicite.findAll", query = "SELECT p FROM Publicite p")
    , @NamedQuery(name = "Publicite.findByIdpublicite", query = "SELECT p FROM Publicite p WHERE p.idpublicite = :idpublicite")
    , @NamedQuery(name = "Publicite.findByNom", query = "SELECT p FROM Publicite p WHERE p.nom = :nom")
    , @NamedQuery(name = "Publicite.findByContenu", query = "SELECT p FROM Publicite p WHERE p.contenu = :contenu")})
public class PubliciteBD implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPUBLICITE")
    private Integer idpublicite;
    @Size(max = 30)
    @Column(name = "NOM")
    private String nom;
    @Size(max = 1000)
    @Column(name = "CONTENU")
    private String contenu;

    public PubliciteBD() {
    }

    public PubliciteBD(String nom, String contenu) {
        this.nom = nom;
        this.contenu = contenu;
    }

    
    
    public PubliciteBD(Integer idpublicite) {
        this.idpublicite = idpublicite;
    }

    public Integer getIdpublicite() {
        return idpublicite;
    }

    public void setIdpublicite(Integer idpublicite) {
        this.idpublicite = idpublicite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpublicite != null ? idpublicite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PubliciteBD)) {
            return false;
        }
        PubliciteBD other = (PubliciteBD) object;
        if ((this.idpublicite == null && other.idpublicite != null) || (this.idpublicite != null && !this.idpublicite.equals(other.idpublicite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.miage.millan.entities.Publicite[ idpublicite=" + idpublicite + " ]";
    }
    
}
