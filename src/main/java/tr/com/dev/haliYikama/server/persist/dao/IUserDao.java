package tr.com.dev.haliYikama.server.persist.dao;

import org.springframework.stereotype.Repository;
import tr.com.dev.haliYikama.server.persist.models.User;
import tr.com.dev.haliYikama.server.utils.interfaces.IGenericDao;

import java.util.List;

/**
 * Created by ramazancesur on 5/19/18.
 */
@Repository("userDao")
public interface IUserDao extends IGenericDao<User, Long> {
    List<User> findByKullaniciAdi(String kullaniciAdi);
}
