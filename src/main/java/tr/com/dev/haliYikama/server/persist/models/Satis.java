package tr.com.dev.haliYikama.server.persist.models;

import tr.com.dev.haliYikama.server.utils.BaseEntity;
import tr.com.dev.haliYikama.server.utils.EnumUtil;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * ******** BURDAKİ SATIS TABLOSU BİZİM SATTIĞIMIZ
 * *******  PROGRAM SATIŞLARIDIR...    ***********
 * Created by ramazancesur on 5/19/18.
 */


@Entity
@Table(name = "SATIS")
public class Satis extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "MUSTERI")
    private Firma musteri;
    @Column(name = "SATIS_FIYATI")
    private BigDecimal satisFiyati;
    @Column(name = "ODEME_TIPI")
    private EnumUtil.ODEME_TYPE odemeType;
    @Column(name = "BITIS_TARIHI")
    private Date bitisTarihi;


    public Firma getMusteri() {
        return musteri;
    }

    public void setMusteri(Firma musteri) {
        this.musteri = musteri;
    }

    public BigDecimal getSatisFiyati() {
        return satisFiyati;
    }

    public void setSatisFiyati(BigDecimal satisFiyati) {
        this.satisFiyati = satisFiyati;
    }

    public EnumUtil.ODEME_TYPE getOdemeType() {
        return odemeType;
    }

    public void setOdemeType(EnumUtil.ODEME_TYPE odemeType) {
        this.odemeType = odemeType;
    }

    public Date getBitisTarihi() {
        return bitisTarihi;
    }

    public void setBitisTarihi(Date bitisTarihi) {
        this.bitisTarihi = bitisTarihi;
    }
}
