package fr.mb.volontario.model.recherche;

import java.util.ArrayList;

public class RechercheMission {
    private Integer domaine;
    private ArrayList<Integer> disponibilite=new ArrayList<>();


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




}
