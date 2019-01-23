package fr.mb.volontario.model.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="benevole")

public class Benevole implements Serializable {
    private Integer idBenevole;
    private String identifiant;
    private String nom;
    private String prenom;
    private String mdp;
    private String mail;
    private Date dateNaissance;
    private Adresse adresse;
    private Set<Inscription> inscriptions;

    public Benevole() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_benevole", nullable = false, unique= true)
    public Integer getIdBenevole() {
        return idBenevole;
    }

    public void setIdBenevole(Integer idBenevole) {
        this.idBenevole = idBenevole;
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
    @Column(name = "nom", nullable = false, length = -1)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "prenom", nullable = false, length = -1)
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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
    @Column(name = "mail", nullable = false, length = -1)
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "date_naissance", nullable = false)
    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Benevole benevole = (Benevole) o;
        return Objects.equals(idBenevole, benevole.idBenevole) &&
                Objects.equals(identifiant, benevole.identifiant) &&
                Objects.equals(nom, benevole.nom) &&
                Objects.equals(prenom, benevole.prenom) &&
                Objects.equals(mdp, benevole.mdp) &&
                Objects.equals(mail, benevole.mail) &&
                Objects.equals(dateNaissance, benevole.dateNaissance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBenevole, identifiant, nom, prenom, mdp, mail, dateNaissance);
    }

    @ManyToOne
    @JoinColumn(name = "id_adresse", referencedColumnName = "id_adresse", nullable = false)
    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
    @ManyToMany(mappedBy = "benevoles")
    public Set<Inscription> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(Set<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }
}
