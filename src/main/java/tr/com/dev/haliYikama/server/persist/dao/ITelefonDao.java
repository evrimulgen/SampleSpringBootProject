package tr.com.dev.haliYikama.server.persist.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.dev.haliYikama.server.persist.models.Telefon;

/**
 * Created by ramazancesur on 5/19/18.
 */
@Repository("telefonDao")
public interface ITelefonDao extends JpaRepository<Telefon, Long> {

}
