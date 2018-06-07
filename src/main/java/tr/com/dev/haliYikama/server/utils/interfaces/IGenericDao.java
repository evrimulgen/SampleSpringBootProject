package tr.com.dev.haliYikama.server.utils.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;
import tr.com.dev.haliYikama.server.utils.BaseEntity;

import java.io.Serializable;

/**
 * Created by ramazancesur on 5/19/18.
 */
@NoRepositoryBean
@Transactional
public interface IGenericDao<T extends BaseEntity, K extends Serializable> extends JpaRepository<T, K> {

}
