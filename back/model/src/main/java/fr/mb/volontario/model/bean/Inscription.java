package fr.mb.volontario.model.bean;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Inscription {
    private Integer idInscription;
    private Integer nbplaces;
    private Timestamp debut;
    private Timestamp fin;
    private Mission mission;

    @Id
    @Column(name = "id_inscription", nullable = false)
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
}
