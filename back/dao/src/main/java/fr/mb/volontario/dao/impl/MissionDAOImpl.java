package fr.mb.volontario.dao.impl;

import fr.mb.volontario.dao.contract.MissionCustomDao;
import fr.mb.volontario.dao.contract.MissionDAO;
import fr.mb.volontario.model.bean.Mission;
import fr.mb.volontario.model.recherche.RechercheMission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MissionDAOImpl implements MissionCustomDao {
    @PersistenceContext
    EntityManager entityManager;

    Logger logger = LoggerFactory.getLogger(MissionDAOImpl.class);

    @Override
    public List<Mission> rechercheMission(RechercheMission recherche) {
        Boolean or= false;
        String SQL = "";
        List listReturn;


            //SELECTION DES MISSIONS
            SQL += " SELECT DISTINCT mission FROM Mission as mission ";

            //JOINTURES DES DOMAINES
            if(!recherche.getDomaine().isEmpty()) SQL += " JOIN mission.domaine as domaine ";

            //JOINTURES DES INSCRIPTIONS
            if (!recherche.getDisponibilite().isEmpty()) SQL += " JOIN mission.inscriptions as inscription ";

            // CRITERE DU DOMAINE
            if (!recherche.getDomaine().isEmpty()||!recherche.getDisponibilite().isEmpty()){
            SQL +=  " WHERE ";

                if(!recherche.getDomaine().isEmpty()){
                    SQL += " ( domaine.idDomaine IN (:domaine)) ";
                }


            }


            if (!recherche.getDisponibilite().isEmpty()) {
                SQL += " AND ( ";


                if (recherche.getDisponibilite().contains(1)) {
                    SQL += " ( EXTRACT (hour FROM inscription.debut) between 6 and 12 ) ";
                    or = true;
                }

                if (recherche.getDisponibilite().contains(2)) {
                    if (or == true) SQL += " OR ";
                    SQL += " ( EXTRACT (hour FROM inscription.debut) between 12 and 14 ) ";
                    or = true;
                }

                if (recherche.getDisponibilite().contains(3)) {
                    if (or == true) SQL += " OR ";
                    SQL += " ( EXTRACT (hour FROM inscription.debut) between 14 and 18 ) ";
                    or = true;
                }

                if (recherche.getDisponibilite().contains(4)) {
                    if (or == true) SQL += " OR ";
                    SQL += " ( EXTRACT (hour FROM inscription.debut) between 18 and 23 ) ";
                }

                SQL += " ) ";
            }
            SQL += " ORDER By mission.idMission ";



        Query query = entityManager.createQuery(SQL);
        if(!recherche.getDomaine().isEmpty()) query.setParameter("domaine",recherche.getDomaine());
        listReturn= query.getResultList();





        return listReturn;
    }
}
