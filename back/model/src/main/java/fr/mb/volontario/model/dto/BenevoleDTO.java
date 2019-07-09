package fr.mb.volontario.model.dto;

import fr.mb.volontario.model.bean.Benevole;

public class BenevoleDTO {
    Benevole benevole;
    String identifiant;
    String mail;

    public BenevoleDTO() {
    }

    public Benevole getBenevole() {
        return benevole;
    }

    public void setBenevole(Benevole benevole) {
        this.benevole = benevole;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
