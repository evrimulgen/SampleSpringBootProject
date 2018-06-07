package tr.com.dev.haliYikama.server.utils;

import org.hibernate.annotations.GenericGenerator;
import tr.com.dev.haliYikama.server.trigger.HibernatPersistListener;
import tr.com.dev.haliYikama.server.trigger.HibernateUpdateListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by ramazancesur on 5/19/18.
 */
@MappedSuperclass
@EntityListeners({
        HibernateUpdateListener.class,
        HibernatPersistListener.class
})
public class BaseEntity implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "OID", unique = true, nullable = false)
    @GenericGenerator(name="keygen" , strategy="increment")
    @GeneratedValue(generator="keygen")
    private Long oid;

    @Version
    @Column(name = "LAST_UPDATED_VERSION")
    private int lastUpdated;

    @Column(name = "CREAYED_DATE")
    private Date createdDate;

    @Column(name = "UPDATED_DATE")
    private Date updatedDate;

    @Column(name = "DURUM")
    private EnumUtil.EntityState entityState;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public int getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(int lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public EnumUtil.EntityState getEntityState() {
        return entityState;
    }

    public void setEntityState(EnumUtil.EntityState entityState) {
        this.entityState = entityState;
    }
}
