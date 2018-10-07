package tr.com.dev.haliYikama.server.trigger;

import tr.com.dev.haliYikama.server.utils.BaseEntity;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Calendar;

/**
 * Created by ramazancesur on 5/19/18.
 */
public class HibernateUpdateListener {
    @PrePersist
    @PreUpdate
    public <T extends BaseEntity> void setUpdatedAt(T entity) {
        Calendar cal = Calendar.getInstance();
        entity.setUpdatedDate(cal.getTime().getTime());
    }

}
