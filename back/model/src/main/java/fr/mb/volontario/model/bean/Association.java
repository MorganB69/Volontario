package fr.mb.volontario.model.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "association")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Association implements Serializable {
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
    private Set<Mission> missions= new HashSet<>();
    private Set<Domaine> domaines= new HashSet<>();

    public Association() {
    }

    public Association(Integer idAssociation, String nom, String mail, String web, String identifiant, String mdp, String siret, String description, String photo) {
        this.idAssociation = idAssociation;
        this.nom = nom;
        this.mail = mail;
        this.web = web;
        this.identifiant = identifiant;
        this.mdp = mdp;
        this.siret = siret;
        this.description = description;
        this.photo = photo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_association", nullable = false, unique=true)
    public Integer getIdAssociation() {
        return idAssociation;
    }

    public void setIdAssociation(Integer idAssociation) {
        this.idAssociation = idAssociation;
    }

    @Basic
    @Column(name = "nom", nullable = false)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "mail", nullable = false)
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "web", nullable = true)
    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    @Basic
    @Column(name = "identifiant", nullable = false)
    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    @Basic
    @Column(name = "mdp", nullable = false)
    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    @Basic
    @Column(name = "siret", nullable = false)
    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    @Basic
    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "photo", nullable = false)
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

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_adresse", referencedColumnName = "id_adresse", nullable = false)
    @JsonBackReference(value="asso-adresse")
    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    @OneToMany(mappedBy = "association")
    @JsonManagedReference(value="asso-mission")
    public Set<Mission> getMissions() {
        return missions;
    }

    public void setMissions(Set<Mission> missions) {
        this.missions = missions;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "asso_domaine", joinColumns = {
            @JoinColumn(name = "id_association", nullable = false, updatable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "id_domaine", nullable = false, updatable = false)})
    public Set<Domaine> getDomaines() {
        return domaines;
    }

    public void setDomaines(Set<Domaine> domaines) {
        this.domaines = domaines;
    }
}
