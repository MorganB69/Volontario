package fr.mb.volontario.model.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "utilisateur")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User implements Serializable {
    private Integer idUser;
    private String identifiant;
    private String mdp;
    private String mail;
    private String role;
    private Association association;
    private Benevole benevole;

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_utilisateur", nullable = false, unique=true)
    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
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
    @Column(name = "mdp", nullable = false)
    @JsonIgnore
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
    @Column(name = "role", nullable = false)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_association", referencedColumnName = "id_association")
    public Association getAssociation() {
        return association;
    }

    public void setAssociation(Association association) {
        this.association = association;
    }
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_benevole")
    public Benevole getBenevole() {
        return benevole;
    }

    public void setBenevole(Benevole benevole) {
        this.benevole = benevole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return idUser.equals(user.idUser) &&
                identifiant.equals(user.identifiant) &&
                mdp.equals(user.mdp) &&
                mail.equals(user.mail) &&
                role.equals(user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, identifiant, mdp, mail, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", identifiant='" + identifiant + '\'' +
                ", mdp='" + mdp + '\'' +
                ", mail='" + mail + '\'' +
                ", role='" + role + '\'' +
                ", benevole=" + benevole +
                '}';
    }
}
