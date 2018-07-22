package tr.com.dev.haliYikama.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import tr.com.dev.haliYikama.server.persist.dao.IUrunDao;
import tr.com.dev.haliYikama.server.persist.models.Urunler;
import tr.com.dev.haliYikama.server.service.interfaces.IUrunService;
import tr.com.dev.haliYikama.server.utils.GenericService;
import tr.com.dev.haliYikama.server.utils.interfaces.IGenericDao;

/**
 * Created by ramazancesur on 7/22/18.
 */
@Service
public class UrunService extends GenericService<Urunler, Long> implements IUrunService {
    private IUrunDao urunDao;

    @Autowired
    public UrunService(@Qualifier("urunDao") IGenericDao<Urunler, Long> genericDao) {
        super(genericDao);
        this.urunDao = (IUrunDao) genericDao;
    }
}
