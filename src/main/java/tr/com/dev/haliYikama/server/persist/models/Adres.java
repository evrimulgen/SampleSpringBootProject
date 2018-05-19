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
@Table(name = "ADRES")
public class Adres extends BaseEntity{
    @Column(name = "ADRES")
    private String adres;
    @Column(name = "ADRES_TYPE")
    private EnumUtil.ADRES_TYPE adresType;
    @Column(name = "ADRES_USER_TYPE")
    private EnumUtil.ADRES_USER_TYPE adresUserType;

    public EnumUtil.ADRES_USER_TYPE getAdresUserType() {
        return adresUserType;
    }

    public void setAdresUserType(EnumUtil.ADRES_USER_TYPE adresUserType) {
        this.adresUserType = adresUserType;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public EnumUtil.ADRES_TYPE getAdresType() {
        return adresType;
    }

    public void setAdresType(EnumUtil.ADRES_TYPE adresType) {
        this.adresType = adresType;
    }
}
