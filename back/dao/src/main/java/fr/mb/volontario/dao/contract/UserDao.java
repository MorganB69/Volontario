package fr.mb.volontario.dao.contract;

import fr.mb.volontario.model.bean.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends PagingAndSortingRepository<User,Integer>,UserCustomDao {

    boolean existsByIdentifiant(String identifiant);

}
