package fr.mb.volontario.dao.contract;

import fr.mb.volontario.model.bean.Benevole;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Dao Benevole
 */
@Repository
public interface BenevoleDAO extends PagingAndSortingRepository<Benevole, Integer>, BenevoleCustomDAO{

}
