package fr.mb.volontario.dao.contract;

import fr.mb.volontario.model.bean.Domaine;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DomaineDAO extends PagingAndSortingRepository<Domaine, Integer>, DomaineCustomDAO {
}
