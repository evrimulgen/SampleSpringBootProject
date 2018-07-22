package tr.com.dev.haliYikama.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import tr.com.dev.haliYikama.server.persist.dao.IAdresDao;
import tr.com.dev.haliYikama.server.persist.models.Adres;
import tr.com.dev.haliYikama.server.service.interfaces.IAdresService;
import tr.com.dev.haliYikama.server.utils.GenericService;
import tr.com.dev.haliYikama.server.utils.interfaces.IGenericDao;

@Service("adresService")
public class AdresService extends GenericService<Adres, Long> implements IAdresService {

    private IAdresDao adresDao;

    @Autowired
    public AdresService(@Qualifier("adresDao") IGenericDao<Adres, Long> genericDao) {
        super(genericDao);
        adresDao = (IAdresDao) genericDao;
    }


}
