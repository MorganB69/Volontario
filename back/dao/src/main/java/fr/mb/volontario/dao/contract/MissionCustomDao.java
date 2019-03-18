package fr.mb.volontario.dao.contract;

import fr.mb.volontario.model.bean.Mission;
import fr.mb.volontario.model.recherche.RechercheMission;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface MissionCustomDao  {

    List<Mission> rechercheMission(RechercheMission recherche);
}
