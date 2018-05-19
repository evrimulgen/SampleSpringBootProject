package tr.com.dev.haliYikama.server.persist.models;

import tr.com.dev.haliYikama.server.utils.BaseEntity;
import tr.com.dev.haliYikama.server.utils.EnumUtil;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by ramazancesur on 5/19/18.
 */
@Entity
@Table(name = "TELEFON")
public class Telefon extends BaseEntity{
    @Column(name = "TEL_NO")
    private String tel;
    @Column(name = "TEL_TYPE")
    private EnumUtil.TEL_TYPE telType;

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public EnumUtil.TEL_TYPE getTelType() {
        return telType;
    }

    public void setTelType(EnumUtil.TEL_TYPE telType) {
        this.telType = telType;
    }
}
