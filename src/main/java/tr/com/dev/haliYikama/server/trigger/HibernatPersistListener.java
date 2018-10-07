package tr.com.dev.haliYikama.server.trigger;

import tr.com.dev.haliYikama.server.helper.Helper;
import tr.com.dev.haliYikama.server.utils.BaseEntity;
import tr.com.dev.haliYikama.server.utils.EnumUtil;

import javax.persistence.PrePersist;
import java.util.Calendar;

/**
 * Created by ramazancesur on 5/19/18.
 */
public class HibernatPersistListener {
    private Helper helper = new Helper();

    @PrePersist
    public void setCreatedAt(BaseEntity entity) {
        Calendar cal = Calendar.getInstance();
        entity.setEntityState(EnumUtil.EntityState.ACTIVE);
        entity.setCreatedDate(cal.getTime().getTime());
        entity.setUpdatedDate(cal.getTime().getTime());
    }
}
