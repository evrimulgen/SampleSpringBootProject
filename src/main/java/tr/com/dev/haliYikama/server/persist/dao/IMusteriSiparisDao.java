package tr.com.dev.haliYikama.server.persist.dao;

import org.springframework.stereotype.Repository;
import tr.com.dev.haliYikama.server.persist.models.MusteriSiparis;
import tr.com.dev.haliYikama.server.utils.interfaces.IGenericDao;

/**
 * Created by ramazancesur on 5/19/18.
 */
@Repository("musteriSiparisDao")
public interface IMusteriSiparisDao extends IGenericDao<MusteriSiparis, Long> {

}
