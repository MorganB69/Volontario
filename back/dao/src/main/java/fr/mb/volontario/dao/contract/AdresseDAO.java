package fr.mb.volontario.dao.contract;

import fr.mb.volontario.model.bean.Adresse;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AdresseDAO extends PagingAndSortingRepository<Adresse, Integer>, AdresseCustomDAO {
}
