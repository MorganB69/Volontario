package fr.mb.volontario.model.recherche;

import java.util.ArrayList;

public class RechercheMission {
    private ArrayList<Integer> domaine= new ArrayList<>();
    private ArrayList<Integer> disponibilite=new ArrayList<>();


    public RechercheMission() {
    }

    public ArrayList<Integer> getDomaine() {
        return domaine;
    }

    public void setDomaine(ArrayList<Integer> domaine) {
        this.domaine = domaine;
    }

    public ArrayList<Integer> getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(ArrayList<Integer> disponibilite) {
        this.disponibilite = disponibilite;
    }




}
