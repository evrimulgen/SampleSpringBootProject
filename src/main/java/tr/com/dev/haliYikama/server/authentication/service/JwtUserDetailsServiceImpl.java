package tr.com.dev.haliYikama.server.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tr.com.dev.haliYikama.server.authentication.JwtUserFactory;
import tr.com.dev.haliYikama.server.persist.dao.IUserDao;
import tr.com.dev.haliYikama.server.persist.models.User;

import java.util.List;

/**
 * Created by stephan on 20.03.16.
 */
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserDao userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> lstUser = userRepository.findByKullaniciAdi(username);
        if (lstUser.size() == 0) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return JwtUserFactory.create(lstUser.get(0));
        }
    }
}