package fr.mb.volontario.model.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "domaine")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Domaine implements Serializable {
    private Integer idDomaine;
    private String nom;
    private String description;
    private Set<Mission> missions=new HashSet<>();
    private Set<Association>associations=new HashSet<>();

    public Domaine() {
    }

    @Id
    @Column(name = "id_domaine", nullable = false, unique = true)
    public Integer getIdDomaine() {
        return idDomaine;
    }

    public void setIdDomaine(Integer idDomaine) {
        this.idDomaine = idDomaine;
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
    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Domaine domaine = (Domaine) o;
        return Objects.equals(idDomaine, domaine.idDomaine) &&
                Objects.equals(nom, domaine.nom) &&
                Objects.equals(description, domaine.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDomaine, nom, description);
    }

    @OneToMany(mappedBy = "domaine", fetch = FetchType.LAZY)
    @JsonIgnore
    public Set<Mission> getMissions() {
        return missions;
    }

    public void setMissions(Set<Mission> missions) {
        this.missions = missions;
    }

    @ManyToMany(mappedBy = "domaines", fetch = FetchType.LAZY)
    @JsonIgnore
    public Set<Association> getAssociations() {
        return associations;
    }

    public void setAssociations(Set<Association> associations) {
        this.associations = associations;
    }
}
