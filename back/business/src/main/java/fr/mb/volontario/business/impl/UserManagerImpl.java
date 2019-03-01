package fr.mb.volontario.business.impl;

import fr.mb.volontario.business.contract.UserManager;
import fr.mb.volontario.dao.contract.UserDao;
import fr.mb.volontario.model.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service(value = "userManager")
public class UserManagerImpl implements UserManager, UserDetailsService {
    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDao.findByIdentifiant(s);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getIdentifiant(), user.getMdp(), getAuthority(user));
    }

    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();

            //authorities.add(new SimpleGrantedAuthority(role.getName()));
            authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));

        return authorities;
        //return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    @Override
    public User save(User user) {
        User userReturn = this.userDao.save(user);
        return userReturn;
    }

    @Override
    public List<User> findAll() {
        List<User> userList = (List<User>) this.userDao.findAll();
        return userList;
    }

    @Override
    public void delete(int id) {
        userDao.deleteById(id);
    }

    @Override
    public User findOne(String username) {
        User userReturn = userDao.findByIdentifiant(username);
        return userReturn;
    }

    @Override
    public User findById(int id) {
        Optional<User> user = userDao.findById(id);
        User  userReturn = user.orElse(null);
        return userReturn;
    }

    @Override
    public User update(User user) {
        User userReturn = userDao.save(user);
        return userReturn;
    }
}
