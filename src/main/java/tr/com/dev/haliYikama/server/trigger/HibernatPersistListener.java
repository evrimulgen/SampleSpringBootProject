package tr.com.dev.haliYikama.server.trigger;

import tr.com.dev.haliYikama.server.utils.BaseEntity;

import javax.persistence.PrePersist;
import java.util.Calendar;

/**
 * Created by ramazancesur on 5/19/18.
 */
public class HibernatPersistListener {
    @PrePersist
    public void setCreatedAt(BaseEntity entity) {
        Calendar cal = Calendar.getInstance();
        entity.setCreatedDate(cal.getTime());
        entity.setUpdatedDate(cal.getTime());
    }
}
