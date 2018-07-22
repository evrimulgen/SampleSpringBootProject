package tr.com.dev.haliYikama.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import tr.com.dev.haliYikama.server.persist.dao.IPersonelDao;
import tr.com.dev.haliYikama.server.persist.models.Personel;
import tr.com.dev.haliYikama.server.service.interfaces.IPersonelService;
import tr.com.dev.haliYikama.server.utils.GenericService;
import tr.com.dev.haliYikama.server.utils.interfaces.IGenericDao;

/**
 * Created by ramazancesur on 7/22/18.
 */
@Service("personelService")
public class PersonelService extends GenericService<Personel, Long> implements IPersonelService {
    private IPersonelDao personelDao;

    @Autowired
    public PersonelService(@Qualifier("personelDao") IGenericDao<Personel, Long> genericDao) {
        super(genericDao);
        personelDao = (IPersonelDao) genericDao;
    }

}
