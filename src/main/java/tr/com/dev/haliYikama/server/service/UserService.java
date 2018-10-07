package tr.com.dev.haliYikama.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import tr.com.dev.haliYikama.server.persist.dao.IUserDao;
import tr.com.dev.haliYikama.server.persist.models.User;
import tr.com.dev.haliYikama.server.service.interfaces.IUserService;
import tr.com.dev.haliYikama.server.utils.GenericService;
import tr.com.dev.haliYikama.server.utils.interfaces.IGenericDao;

import java.util.List;

/**
 * Created by ramazancesur on 5/23/18.
 */
@Service
public class UserService extends GenericService<User, Long> implements IUserService {
    private IUserDao userDao;

    @Autowired
    public UserService(@Qualifier("userDao") IGenericDao<User, Long> genericDao) {
        super(genericDao);
        this.userDao = (IUserDao) genericDao;
    }


    @Override
    public User findByKullaniciAdi(String kullaniciAdi) {
        List<User> lstUser = userDao.findByKullaniciAdi(kullaniciAdi);
        return lstUser.size() == 0 ? null : lstUser.get(0);
    }
}
