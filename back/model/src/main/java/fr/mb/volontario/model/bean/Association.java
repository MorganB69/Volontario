package fr.mb.volontario.model.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "association")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Association implements Serializable {
    private Integer idAssociation;
    private String nom;
    private String web;
    private String siret;
    private String description;
    private String photo;
    private Adresse adresse;
    private Set<Mission> missions= new HashSet<>();
    private Set<Domaine> domaines= new HashSet<>();
    private Set<User> users= new HashSet<>();

    public Association() {
    }

    public Association(Integer idAssociation, String nom, String web, String siret, String description, String photo) {
        this.idAssociation = idAssociation;
        this.nom = nom;
        this.web = web;
        this.siret = siret;
        this.description = description;
        this.photo = photo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_association", nullable = false, unique=true)
    public Integer getIdAssociation() {
        return idAssociation;
    }

    public void setIdAssociation(Integer idAssociation) {
        this.idAssociation = idAssociation;
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
    @Column(name = "web", nullable = true)
    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }


    @Basic
    @Column(name = "siret", nullable = false)
    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    @Basic
    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "photo")
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Association that = (Association) o;
        return Objects.equals(idAssociation, that.idAssociation) &&
                Objects.equals(nom, that.nom) &&
                Objects.equals(web, that.web) &&
                Objects.equals(siret, that.siret) &&
                Objects.equals(description, that.description) &&
                Objects.equals(photo, that.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAssociation, nom,  web, siret, description, photo);
    }

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_adresse", referencedColumnName = "id_adresse", nullable = false)
    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    @OneToMany(mappedBy = "association")
    @JsonBackReference(value="asso-mission")
    public Set<Mission> getMissions() {
        return missions;
    }

    public void setMissions(Set<Mission> missions) {
        this.missions = missions;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "asso_domaine", joinColumns = {
            @JoinColumn(name = "id_association", nullable = false, updatable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "id_domaine", nullable = false, updatable = false)})
    public Set<Domaine> getDomaines() {
        return domaines;
    }

    public void setDomaines(Set<Domaine> domaines) {
        this.domaines = domaines;
    }

    @OneToMany(mappedBy = "association", cascade = CascadeType.ALL)
    @JsonManagedReference(value="asso-user")
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Association{" +
                "idAssociation=" + idAssociation +
                ", nom='" + nom + '\'' +
                ", web='" + web + '\'' +
                ", siret='" + siret + '\'' +
                ", description='" + description + '\'' +
                ", photo='" + photo + '\'' +
                ", adresse=" + adresse +
                ", missions=" + missions +
                ", domaines=" + domaines +
                ", users=" + users +
                '}';
    }
}
