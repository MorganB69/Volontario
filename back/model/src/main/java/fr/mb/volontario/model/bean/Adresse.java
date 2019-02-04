package fr.mb.volontario.model.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "adresse")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Adresse implements Serializable {
    private Integer idAdresse;
    private String voie;
    private String code;
    private String commune;
    private String region;
    private String departement;
    private Set<Association> associations = new HashSet<>();
    private Set<Benevole> benevoles= new HashSet<>();
    private Set<Mission> missions= new HashSet<>();

    public Adresse() {
    }

    public Adresse(Integer idAdresse, String voie, String code, String commune, String region, String departement) {
        this.idAdresse = idAdresse;
        this.voie = voie;
        this.code = code;
        this.commune = commune;
        this.region = region;
        this.departement = departement;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_adresse", nullable = false, unique = true)
    public Integer getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(Integer idAdresse) {
        this.idAdresse = idAdresse;
    }

    @Basic
    @Column(name = "voie", nullable = false)
    public String getVoie() {
        return voie;
    }

    public void setVoie(String voie) {
        this.voie = voie;
    }

    @Basic
    @Column(name = "code", nullable = false)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "commune", nullable = false)
    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    @Basic
    @Column(name = "region", nullable = false)
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Basic
    @Column(name = "departement", nullable = false)
    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adresse adresse = (Adresse) o;
        return Objects.equals(idAdresse, adresse.idAdresse) &&
                Objects.equals(voie, adresse.voie) &&
                Objects.equals(code, adresse.code) &&
                Objects.equals(commune, adresse.commune) &&
                Objects.equals(region, adresse.region) &&
                Objects.equals(departement, adresse.departement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAdresse, voie, code, commune, region, departement);
    }

    @OneToMany(mappedBy = "adresse", cascade = CascadeType.REFRESH)
    @JsonBackReference
    public Set<Association> getAssociations() {
        return associations;
    }

    public void setAssociations(Set<Association> associations) {
        this.associations = associations;
    }

    @OneToMany(mappedBy = "adresse")
    @JsonBackReference
    public Set<Benevole> getBenevoles() {
        return benevoles;
    }

    public void setBenevoles(Set<Benevole> benevoles) {
        this.benevoles = benevoles;
    }

    @OneToMany(mappedBy = "adresse")
    @JsonBackReference
    public Set<Mission> getMissions() {
        return missions;
    }

    public void setMissions(Set<Mission> missions) {
        this.missions = missions;
    }
}
