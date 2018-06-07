package tr.com.dev.haliYikama.server.persist.models;

import tr.com.dev.haliYikama.server.utils.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by ramazancesur on 5/19/18.
 */
@Entity
@Table
public class Siparis extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "MUSTERI")
    private Urunler urun;

    @Column(name = "SIPARIS_TUTARI")
    private BigDecimal siparisTutari;

    public BigDecimal getSiparisTutari() {
        return siparisTutari;
    }

    public void setSiparisTutari(BigDecimal siparisTutari) {
        this.siparisTutari = siparisTutari;
    }

    public Urunler getUrun() {
        return urun;
    }

    public void setUrun(Urunler urun) {
        this.urun = urun;
    }
}
