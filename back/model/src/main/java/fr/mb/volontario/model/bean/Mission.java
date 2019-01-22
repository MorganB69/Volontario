package fr.mb.volontario.model.bean;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Mission {
    private String nom;
    private String description;
    private String complement;
    private String competence;
    private Set<Inscription> inscriptions;
    private Association association;
    private Adresse adresse;
    private Domaine domaine;

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

    @Basic
    @Column(name = "complement", nullable = true, length = -1)
    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    @Basic
    @Column(name = "competence", nullable = false, length = -1)
    public String getCompetence() {
        return competence;
    }

    public void setCompetence(String competence) {
        this.competence = competence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mission mission = (Mission) o;
        return Objects.equals(nom, mission.nom) &&
                Objects.equals(description, mission.description) &&
                Objects.equals(complement, mission.complement) &&
                Objects.equals(competence, mission.competence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, description, complement, competence);
    }

    @OneToMany(mappedBy = "mission")
    public Set<Inscription> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(Set<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }

    @ManyToOne
    @JoinColumn(name = "id_association", referencedColumnName = "id_association", nullable = false)
    public Association getAssociation() {
        return association;
    }

    public void setAssociation(Association association) {
        this.association = association;
    }

    @ManyToOne
    @JoinColumn(name = "id_adresse", referencedColumnName = "id_adresse", nullable = false)
    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    @ManyToOne
    @JoinColumn(name = "id_domaine", referencedColumnName = "id_domaine", nullable = false)
    public Domaine getDomaine() {
        return domaine;
    }

    public void setDomaine(Domaine domaine) {
        this.domaine = domaine;
    }
}
