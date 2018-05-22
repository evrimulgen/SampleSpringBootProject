package tr.com.dev.haliYikama.server.persist.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tr.com.dev.haliYikama.server.persist.models.Adres;
import tr.com.dev.haliYikama.server.utils.interfaces.IGenericDao;

import java.util.List;

/**
 * Created by ramazancesur on 5/19/18.
 */
@Repository("adresDao")
public interface IAdresDao extends IGenericDao<Adres, Long> {
    @Modifying
    @Query("from Adres ")
    List<Adres> getFirmaAdresleri();
}
