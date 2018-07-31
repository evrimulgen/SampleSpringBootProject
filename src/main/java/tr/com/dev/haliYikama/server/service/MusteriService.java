package tr.com.dev.haliYikama.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import tr.com.dev.haliYikama.server.persist.dao.IMusteriDao;
import tr.com.dev.haliYikama.server.persist.models.Musteri;
import tr.com.dev.haliYikama.server.service.interfaces.IMusteriService;
import tr.com.dev.haliYikama.server.utils.GenericService;
import tr.com.dev.haliYikama.server.utils.interfaces.IGenericDao;

/**
 * Created by ramazancesur on 7/31/18.
 */
@Service("musteriService")
public class MusteriService extends GenericService<Musteri, Long> implements IMusteriService {
    private IMusteriDao musteriDao;

    @Autowired
    public MusteriService(@Qualifier("musteriDao") IGenericDao<Musteri, Long> genericDao) {
        super(genericDao);
        musteriDao = (IMusteriDao) genericDao;
    }

}
