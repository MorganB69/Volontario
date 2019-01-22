package fr.mb.volontario.model.bean;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Association {
    private Integer idAssociation;
    private String nom;
    private String mail;
    private String web;
    private String identifiant;
    private String mdp;
    private String siret;
    private String description;
    private String photo;
    private Adresse adresse;
    private Set<Mission> missions;

    @Id
    @Column(name = "id_association", nullable = false)
    public Integer getIdAssociation() {
        return idAssociation;
    }

    public void setIdAssociation(Integer idAssociation) {
        this.idAssociation = idAssociation;
    }

    @Basic
    @Column(name = "nom", nullable = false, length = -1)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "mail", nullable = false, length = -1)
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "web", nullable = true, length = -1)
    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    @Basic
    @Column(name = "identifiant", nullable = false, length = -1)
    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    @Basic
    @Column(name = "mdp", nullable = false, length = -1)
    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    @Basic
    @Column(name = "siret", nullable = false, length = -1)
    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    @Basic
    @Column(name = "description", nullable = false, length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "photo", nullable = false, length = -1)
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Association that = (Association) o;
        return Objects.equals(idAssociation, that.idAssociation) &&
                Objects.equals(nom, that.nom) &&
                Objects.equals(mail, that.mail) &&
                Objects.equals(web, that.web) &&
                Objects.equals(identifiant, that.identifiant) &&
                Objects.equals(mdp, that.mdp) &&
                Objects.equals(siret, that.siret) &&
                Objects.equals(description, that.description) &&
                Objects.equals(photo, that.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAssociation, nom, mail, web, identifiant, mdp, siret, description, photo);
    }

    @ManyToOne
    @JoinColumn(name = "id_adresse", referencedColumnName = "id_adresse", nullable = false)
    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    @OneToMany(mappedBy = "association")
    public Set<Mission> getMissions() {
        return missions;
    }

    public void setMissions(Set<Mission> missions) {
        this.missions = missions;
    }
}
