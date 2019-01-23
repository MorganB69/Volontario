package fr.mb.volontario.dao.contract;

import fr.mb.volontario.model.bean.Mission;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *Dao For Mission
 */
@Repository
public interface MissionDAO extends PagingAndSortingRepository<Mission,Integer>,MissionCustomDao {


}
