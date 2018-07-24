package tr.com.dev.haliYikama.server.persist.dao;

import org.springframework.stereotype.Repository;
import tr.com.dev.haliYikama.server.persist.models.Siparis;
import tr.com.dev.haliYikama.server.utils.interfaces.IGenericDao;

/**
 * Created by ramazancesur on 7/23/18.
 */
@Repository("siparisDao")
public interface ISiparisDao extends IGenericDao<Siparis, Long> {


}
