package tr.com.dev.haliYikama.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import tr.com.dev.haliYikama.server.persist.dao.ISiparisDao;
import tr.com.dev.haliYikama.server.persist.models.Siparis;
import tr.com.dev.haliYikama.server.service.interfaces.ISiparisService;
import tr.com.dev.haliYikama.server.utils.GenericService;
import tr.com.dev.haliYikama.server.utils.interfaces.IGenericDao;

/**
 * Created by ramazancesur on 7/31/18.
 */
@Service("siparisService")
public class SiparisService extends GenericService<Siparis, Long> implements ISiparisService {
    private ISiparisDao siparisDao;

    @Autowired
    public SiparisService(@Qualifier("siparisDao") IGenericDao<Siparis, Long> genericDao) {
        super(genericDao);
        siparisDao = (ISiparisDao) genericDao;
    }

}
