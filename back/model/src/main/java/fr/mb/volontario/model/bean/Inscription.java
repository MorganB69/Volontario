package fr.mb.volontario.model.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="inscription")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Inscription implements Serializable {
    private Integer idInscription;
    private Integer nbplaces;
    private Timestamp debut;
    private Timestamp fin;
    private String consigne;
    private Mission mission;
    private Set<Benevole> benevoles=new HashSet<>();

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
                Objects.equals(consigne, that.consigne) &&
                Objects.equals(fin, that.fin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idInscription, nbplaces, debut, fin, consigne);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mission", referencedColumnName = "id_mission", nullable = false)
    @JsonBackReference(value = "mission-inscri")
    public Mission getMission() {
        return mission;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "benevole_inscription", joinColumns = {
            @JoinColumn(name = "id_inscription", nullable = false, updatable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "id_benevole", nullable = false, updatable = false)
    })
    @JsonIgnore
    public Set<Benevole> getBenevoles() {
        return benevoles;
    }

    public void setBenevoles(Set<Benevole> benevoles) {
        this.benevoles = benevoles;
    }

    @Basic
    @Column(name = "consigne", nullable = false)
    public String getConsigne() {
        return consigne;
    }

    public void setConsigne(String consigne) {
        this.consigne = consigne;
    }
}
