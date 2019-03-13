package fr.mb.volontario.dao.contract;

import fr.mb.volontario.model.bean.Inscription;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface InscriptionDAO extends PagingAndSortingRepository<Inscription, Integer> {
}
