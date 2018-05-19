package tr.com.dev.haliYikama.server.persist.models;

import tr.com.dev.haliYikama.server.utils.BaseEntity;
import tr.com.dev.haliYikama.server.utils.EnumUtil;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by ramazancesur on 5/19/18.
 */
@Entity
@Table(name = "URUNLER")
public class Urunler extends BaseEntity {
    @Column(name = "URUN_ADI")
    private String urunAdi;
    @Column(name = "FIYATI")
    private BigDecimal fiyati;
    @Column(name = "URUN_CINSI")
    private EnumUtil.URUN_CINSI urunCinsi;
    @ManyToOne
    @JoinColumn
    private Firma firma;

    public String getUrunAdi() {
        return urunAdi;
    }

    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }

    public BigDecimal getFiyati() {
        return fiyati;
    }

    public void setFiyati(BigDecimal fiyati) {
        this.fiyati = fiyati;
    }

    public EnumUtil.URUN_CINSI getUrunCinsi() {
        return urunCinsi;
    }

    public void setUrunCinsi(EnumUtil.URUN_CINSI urunCinsi) {
        this.urunCinsi = urunCinsi;
    }

    public Firma getFirma() {
        return firma;
    }

    public void setFirma(Firma firma) {
        this.firma = firma;
    }
}
