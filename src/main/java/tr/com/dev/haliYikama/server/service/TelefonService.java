package tr.com.dev.haliYikama.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import tr.com.dev.haliYikama.server.persist.dao.ITelefonDao;
import tr.com.dev.haliYikama.server.persist.models.Telefon;
import tr.com.dev.haliYikama.server.service.interfaces.ITelefonService;
import tr.com.dev.haliYikama.server.utils.GenericService;
import tr.com.dev.haliYikama.server.utils.interfaces.IGenericDao;

/**
 * Created by ramazancesur on 5/24/18.
 */
@Service
public class TelefonService extends GenericService<Telefon, Long> implements ITelefonService {
    private ITelefonDao telefonDao;

    @Autowired
    public TelefonService(@Qualifier("telefonDao") IGenericDao<Telefon, Long> genericDao) {
        super(genericDao);
        this.telefonDao = (ITelefonDao) genericDao;
    }


}
