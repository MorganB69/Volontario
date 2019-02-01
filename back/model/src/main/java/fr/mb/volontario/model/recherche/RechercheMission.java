package fr.mb.volontario.model.recherche;

import java.util.ArrayList;

public class RechercheMission {
    private Integer domaine;
    private ArrayList<Integer> disponibilite=new ArrayList<>();
    private  String commune;
    private String departement;
    private String code;

    public RechercheMission() {
    }

    public Integer getDomaine() {
        return domaine;
    }

    public void setDomaine(Integer domaine) {
        this.domaine = domaine;
    }

    public ArrayList<Integer> getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(ArrayList<Integer> disponibilite) {
        this.disponibilite = disponibilite;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
