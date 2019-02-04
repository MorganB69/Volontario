package fr.mb.volontario.model.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="benevole")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Benevole implements Serializable {
    private Integer idBenevole;
    private String identifiant;
    private String nom;
    private String prenom;
    private String mdp;
    private String mail;
    private LocalDate dateNaissance;
    private Adresse adresse;
    private Set<Inscription> inscriptions=new HashSet<>();

    public Benevole() {
    }

    public Benevole(Integer idBenevole, String identifiant, String nom, String prenom, String mdp, String mail, LocalDate dateNaissance) {
        this.idBenevole = idBenevole;
        this.identifiant = identifiant;
        this.nom = nom;
        this.prenom = prenom;
        this.mdp = mdp;
        this.mail = mail;
        this.dateNaissance = dateNaissance;
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
    @Column(name = "identifiant", nullable = false)
    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
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
    @Column(name = "prenom", nullable = false)
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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
    @Column(name = "mail", nullable = false)
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "date_naissance", nullable = false)
    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
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

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_adresse", referencedColumnName = "id_adresse", nullable = false)
    @JsonManagedReference
    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
    @ManyToMany(mappedBy = "benevoles", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JsonManagedReference
    public Set<Inscription> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(Set<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }
}
