package tr.com.dev.haliYikama.server.persist.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.dev.haliYikama.server.utils.BaseEntity;

/**
 * Created by ramazancesur on 5/19/18.
 */
@Repository("firmaDao")
public interface IFirmaDao extends JpaRepository<BaseEntity,Long> {

}
