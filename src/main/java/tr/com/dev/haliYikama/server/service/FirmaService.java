package tr.com.dev.haliYikama.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import tr.com.dev.haliYikama.server.persist.dao.IFirmaDao;
import tr.com.dev.haliYikama.server.persist.models.Firma;
import tr.com.dev.haliYikama.server.service.interfaces.IFirmaService;
import tr.com.dev.haliYikama.server.utils.GenericService;
import tr.com.dev.haliYikama.server.utils.interfaces.IGenericDao;

@Service
public class FirmaService extends GenericService<Firma, Long> implements IFirmaService {
    private IFirmaDao firmaDao;

    @Autowired
    public FirmaService(@Qualifier("firmaDao") IGenericDao<Firma, Long> genericDao) {
        super(genericDao);
        firmaDao = (IFirmaDao) genericDao;
    }

}
