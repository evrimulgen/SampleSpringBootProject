package tr.com.dev.haliYikama.server.persist.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by ramazancesur on 5/19/18.
 */
@Entity
@Table(name = "PERSONEL")
public class Personel extends User {
    @Column(name = "ADI")
    private String adi;
    @Column(name = "SOYADI")
    private String soyadi;
    @Column(name = "DOGUM_TARIHI")
    private long dogumTarihi;

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public long getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(long dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }
}
