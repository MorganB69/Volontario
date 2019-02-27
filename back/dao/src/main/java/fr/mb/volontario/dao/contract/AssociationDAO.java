package fr.mb.volontario.dao.contract;

import fr.mb.volontario.model.bean.Association;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DAO for Association
 */
@Repository
public interface AssociationDAO extends PagingAndSortingRepository<Association, Integer>, AssociationCustomDAO {

    boolean existsBySiret(String siret);

}
