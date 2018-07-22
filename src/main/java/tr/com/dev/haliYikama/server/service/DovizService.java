package tr.com.dev.haliYikama.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import tr.com.dev.haliYikama.server.persist.dao.IDovizDao;
import tr.com.dev.haliYikama.server.persist.models.Doviz;
import tr.com.dev.haliYikama.server.service.interfaces.IDovizService;
import tr.com.dev.haliYikama.server.utils.GenericService;
import tr.com.dev.haliYikama.server.utils.interfaces.IGenericDao;

import java.util.List;

@Service
public class DovizService extends GenericService<Doviz, Long> implements IDovizService {
    private IDovizDao dovizDao;

    @Autowired
    public DovizService(@Qualifier("dovizDao") IGenericDao<Doviz, Long> genericDao) {
        super(genericDao);
        dovizDao = (IDovizDao) genericDao;
    }

    @Override
    public Doviz getDovizKodunaGore(String dovizKodu) {
        List<Doviz> lstDoviz = dovizDao.findByDovizKoduOrderByUpdatedDateDesc(dovizKodu);
        return lstDoviz.size() != 0 ? lstDoviz.get(0) : new Doviz();
    }
}
