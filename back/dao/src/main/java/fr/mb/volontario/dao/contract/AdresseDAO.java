package fr.mb.volontario.dao.contract;

import fr.mb.volontario.model.bean.Adresse;

import fr.mb.volontario.model.recherche.RechercheAdresse;
import fr.mb.volontario.model.recherche.RechercheMission;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdresseDAO extends PagingAndSortingRepository<Adresse, Integer>, AdresseCustomDAO {

    @Query("select distinct mission.adresse.departement as departement from Mission as mission order by departement asc ")
    List<String>getDepartement();

    @Query("select distinct mission.adresse.commune as commune from Mission as mission where mission.adresse.departement = :dep order by commune asc")
    List<String>getCommunes(@Param("dep") String dep);


}
