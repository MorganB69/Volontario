package fr.mb.volontario.model.bean;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Domaine {
    private Integer idDomaine;
    private String nom;
    private String description;
    private Set<Mission> missions;

    @Id
    @Column(name = "id_domaine", nullable = false)
    public Integer getIdDomaine() {
        return idDomaine;
    }

    public void setIdDomaine(Integer idDomaine) {
        this.idDomaine = idDomaine;
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
    @Column(name = "description", nullable = false, length = -1)
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

    @OneToMany(mappedBy = "domaine")
    public Set<Mission> getMissions() {
        return missions;
    }

    public void setMissions(Set<Mission> missions) {
        this.missions = missions;
    }
}
