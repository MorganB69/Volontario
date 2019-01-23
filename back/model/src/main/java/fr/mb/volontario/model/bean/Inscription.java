package fr.mb.volontario.model.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="inscription")
public class Inscription implements Serializable {
    private Integer idInscription;
    private Integer nbplaces;
    private Timestamp debut;
    private Timestamp fin;
    private Mission mission;
    private Set<Benevole> benevoles;

    public Inscription() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inscription", nullable = false, unique=true)
    public Integer getIdInscription() {
        return idInscription;
    }

    public void setIdInscription(Integer idInscription) {
        this.idInscription = idInscription;
    }

    @Basic
    @Column(name = "nbplaces", nullable = false)
    public Integer getNbplaces() {
        return nbplaces;
    }

    public void setNbplaces(Integer nbplaces) {
        this.nbplaces = nbplaces;
    }

    @Basic
    @Column(name = "debut", nullable = false)
    public Timestamp getDebut() {
        return debut;
    }

    public void setDebut(Timestamp debut) {
        this.debut = debut;
    }

    @Basic
    @Column(name = "fin", nullable = false)
    public Timestamp getFin() {
        return fin;
    }

    public void setFin(Timestamp fin) {
        this.fin = fin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inscription that = (Inscription) o;
        return Objects.equals(idInscription, that.idInscription) &&
                Objects.equals(nbplaces, that.nbplaces) &&
                Objects.equals(debut, that.debut) &&
                Objects.equals(fin, that.fin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idInscription, nbplaces, debut, fin);
    }

    @ManyToOne
    @JoinColumn(name = "id_mission", referencedColumnName = "id_mission", nullable = false)
    public Mission getMission() {
        return mission;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }

    @ManyToMany
    @JoinTable(name = "benevole_inscription", joinColumns = {
            @JoinColumn(name = "id_inscription", nullable = false, updatable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "id_benevole", nullable = false, updatable = false)
    })
    public Set<Benevole> getBenevoles() {
        return benevoles;
    }

    public void setBenevoles(Set<Benevole> benevoles) {
        this.benevoles = benevoles;
    }
}
