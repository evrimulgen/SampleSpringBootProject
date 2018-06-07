package tr.com.dev.haliYikama.server.persist.dao;

import org.springframework.stereotype.Repository;
import tr.com.dev.haliYikama.server.persist.models.Urunler;
import tr.com.dev.haliYikama.server.utils.interfaces.IGenericDao;

/**
 * Created by ramazancesur on 5/19/18.
 */
@Repository("urunDao")
public interface IUrunDao extends IGenericDao<Urunler, Long> {

}
