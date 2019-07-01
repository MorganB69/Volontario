package fr.mb.volontario.dao.contract;

import fr.mb.volontario.model.bean.Inscription;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface InscriptionDAO extends PagingAndSortingRepository<Inscription, Integer> {

    List<Inscription> findAllByMissionIdMission(Integer idMission);
}
