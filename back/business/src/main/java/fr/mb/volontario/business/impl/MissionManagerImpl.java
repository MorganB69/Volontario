package fr.mb.volontario.business.impl;

import fr.mb.volontario.business.contract.MissionManager;
import fr.mb.volontario.dao.contract.AdresseDAO;
import fr.mb.volontario.dao.contract.DomaineDAO;
import fr.mb.volontario.dao.contract.MissionDAO;
import fr.mb.volontario.model.bean.Domaine;
import fr.mb.volontario.model.bean.Mission;
import fr.mb.volontario.model.exception.FunctionalException;
import fr.mb.volontario.model.exception.NotFoundException;
import fr.mb.volontario.model.recherche.RechercheAdresse;
import fr.mb.volontario.model.recherche.RechercheMission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MissionManagerImpl implements MissionManager {

    @Autowired
    MissionDAO missionDAO;

    @Autowired
    DomaineDAO domaineDAO;

    @Autowired
    AdresseDAO adresseDAO;

    @Override
    @Transactional
    public List<Mission> rechercheMission(RechercheMission recherche) throws FunctionalException {
        List<Mission> listReturn = null;
        try {
            listReturn = missionDAO.rechercheMission(recherche);
        }
        catch (Exception exception) {
            throw new FunctionalException("Une erreur est parvenue dans la recherche");
        }

        return listReturn;
    }

    @Override
    @Transactional
    public List<Domaine> findAllDomaine() throws NotFoundException {

        List<Domaine>listReturn = (List<Domaine>) domaineDAO.findAll();
        if (listReturn==null) throw new NotFoundException("Aucun domaine trouvé");

        return listReturn;
    }

    @Override
    @Transactional
    public List<String> findDepartement() throws NotFoundException {
        List<String> listReturn = adresseDAO.getDepartement();
        if (listReturn==null) throw new NotFoundException("Pas d'adresse trouvée");
        return listReturn;
    }

    @Override
    @Transactional
    public List<String> findCommune(String departement) throws NotFoundException {
        List<String> listReturn = adresseDAO.getCommunes(departement);
        if (listReturn==null) throw new NotFoundException("Pas d'adresse trouvée");
        return listReturn;
    }




}
