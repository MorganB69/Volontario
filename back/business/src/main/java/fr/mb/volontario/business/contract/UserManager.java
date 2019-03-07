package fr.mb.volontario.business.contract;

import fr.mb.volontario.model.bean.User;

import java.util.List;

public interface UserManager {
    User save(User user);
    List<User> findAll();
    void delete(int id);

    User findOne(String username);

    User findById(int id);

    User update(User userDto);
}
