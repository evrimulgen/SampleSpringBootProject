package tr.com.dev.haliYikama.server.persist.dao;

import org.springframework.stereotype.Repository;
import tr.com.dev.haliYikama.server.persist.models.Doviz;
import tr.com.dev.haliYikama.server.utils.interfaces.IGenericDao;

import java.util.List;

@Repository("dovizDao")
public interface IDovizDao extends IGenericDao<Doviz, Long> {
    List<Doviz> findByDovizKoduOrderByUpdatedDateDesc(String dovizKodu);
}
