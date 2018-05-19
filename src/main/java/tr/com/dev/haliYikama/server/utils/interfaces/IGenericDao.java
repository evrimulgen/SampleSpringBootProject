package tr.com.dev.haliYikama.server.utils.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;
import tr.com.dev.haliYikama.server.utils.BaseEntity;

import java.io.Serializable;
import java.util.Optional;

/**
 * Created by ramazancesur on 5/19/18.
 */
@NoRepositoryBean
@Transactional
public interface IGenericDao<T extends BaseEntity, K extends Serializable> extends JpaRepository<T,K> {

    @Override
    @Modifying
    @Query("from BaseEntity where entityState= 0 and oid = :oid ")
    Optional<T> findById(K oid);

}
