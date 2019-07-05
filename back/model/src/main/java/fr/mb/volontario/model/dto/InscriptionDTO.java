package fr.mb.volontario.model.dto;

import fr.mb.volontario.model.bean.Benevole;
import fr.mb.volontario.model.bean.Inscription;

import java.util.ArrayList;
import java.util.List;

public class InscriptionDTO {
    Inscription inscription;
    List<BenevoleDTO> benevole = new ArrayList<>();
    Integer nbInscription;

    public InscriptionDTO() {
    }

    public List<BenevoleDTO> getBenevole() {
        return benevole;
    }

    public void setBenevole(List<BenevoleDTO> benevole) {
        this.benevole = benevole;
    }

    public Integer getNbInscription() {
        return nbInscription;
    }

    public void setNbInscription(Integer nbInscription) {
        this.nbInscription = nbInscription;
    }

    public Inscription getInscription() {
        return inscription;
    }

    public void setInscription(Inscription inscription) {
        this.inscription = inscription;
    }
}
