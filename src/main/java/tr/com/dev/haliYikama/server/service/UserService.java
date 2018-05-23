package tr.com.dev.haliYikama.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import tr.com.dev.haliYikama.server.persist.dao.IUserDao;
import tr.com.dev.haliYikama.server.persist.models.User;
import tr.com.dev.haliYikama.server.service.interfaces.IUserService;
import tr.com.dev.haliYikama.server.utils.GenericService;
import tr.com.dev.haliYikama.server.utils.interfaces.IGenericDao;

/**
 * Created by ramazancesur on 5/23/18.
 */
public class UserService extends GenericService<User, Long> implements IUserService {
    private IUserDao userDao;

    @Autowired
    public UserService(@Qualifier("userDao") IGenericDao<User, Long> genericDao) {
        super(genericDao);
        this.userDao = (IUserDao) genericDao;
    }


    @Override
    public User findByKullaniciAdi(String kullaniciAdi) {
        return userDao.findByKullaniciAdi(kullaniciAdi);
    }
}
