package tr.com.dev.haliYikama.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import tr.com.dev.haliYikama.server.persist.dao.IMusteriSiparisDao;
import tr.com.dev.haliYikama.server.persist.models.MusteriSiparis;
import tr.com.dev.haliYikama.server.service.interfaces.IMusteriSiparisService;
import tr.com.dev.haliYikama.server.utils.GenericService;
import tr.com.dev.haliYikama.server.utils.interfaces.IGenericDao;

/**
 * Created by ramazancesur on 7/31/18.
 */
@Service("musteriSiparisService")
public class MusteriSiparisService extends GenericService<MusteriSiparis, Long> implements IMusteriSiparisService {

    private IMusteriSiparisDao musteriSiparisDao;

    @Autowired
    public MusteriSiparisService(@Qualifier("musteriSiparisDao") IGenericDao<MusteriSiparis, Long> genericDao) {
        super(genericDao);
        musteriSiparisDao = (IMusteriSiparisDao) genericDao;
    }
}
