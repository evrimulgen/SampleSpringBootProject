package tr.com.dev.haliYikama.server.service.interfaces;

import tr.com.dev.haliYikama.server.persist.models.User;
import tr.com.dev.haliYikama.server.utils.interfaces.IGenericService;

/**
 * Created by ramazancesur on 5/23/18.
 */
public interface IUserService extends IGenericService<User, Long> {
    User findByKullaniciAdi(String kullaniciAdi);
}
