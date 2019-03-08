package fr.mb.volontario.model.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    private String nom;
    private String prenom;
    private Adresse adresse;
    private Set<Inscription> inscriptions=new HashSet<>();
    private User user;

    public Benevole() {
    }

    public Benevole(Integer idBenevole, String nom, String prenom, LocalDate dateNaissance) {
        this.idBenevole = idBenevole;
        this.nom = nom;
        this.prenom = prenom;
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




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Benevole benevole = (Benevole) o;
        return Objects.equals(idBenevole, benevole.idBenevole) &&
                Objects.equals(nom, benevole.nom) &&
                Objects.equals(prenom, benevole.prenom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBenevole, nom, prenom);
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_adresse", referencedColumnName = "id_adresse", nullable = false)
    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
    @ManyToMany(mappedBy = "benevoles", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    public Set<Inscription> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(Set<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }

    @OneToOne(mappedBy = "benevole", cascade = CascadeType.ALL)
    @JsonManagedReference(value="bene-user")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
