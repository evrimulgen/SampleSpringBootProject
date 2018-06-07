package tr.com.dev.haliYikama.server.persist.models;

import tr.com.dev.haliYikama.server.utils.BaseEntity;
import tr.com.dev.haliYikama.server.utils.EnumUtil;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by ramazancesur on 5/19/18.
 */
@Entity
@Table(name = "MUSTERI_SIPARIS")
public class MusteriSiparis extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "MUSTERI")
    private Musteri musteri;

    @ManyToOne
    @JoinColumn(name = "FIRMA")
    private Firma firma;

    @OneToMany
    @JoinColumn(name = "MUST_SIPARIS__OID")
    private List<Siparis> lstSiparis;

    @Column(name = "TOPLAM_SIPARIS_TUTARI")
    private BigDecimal toplamSiparisTutari;

    @Column(name = "ISKONTOLU_FIYAT")
    private BigDecimal iskontoluFiyat;

    @Column(name = "KALAN_BORC")
    private BigDecimal kalanBorc;

    @Column(name = "MUSTERI_NOTU")
    private String musteriNotu;

    @Column(name = "TESLIM_TARIHI")
    private Date teslimTarihi;

    @Column(name = "SIPARIS_DURUMU")
    private EnumUtil.SIPARIS_DURUMU siparis_durumu;


    public Musteri getMusteri() {
        return musteri;
    }

    public void setMusteri(Musteri musteri) {
        this.musteri = musteri;
    }

    public Firma getFirma() {
        return firma;
    }

    public void setFirma(Firma firma) {
        this.firma = firma;
    }

    public List<Siparis> getLstSiparis() {
        return lstSiparis;
    }

    public void setLstSiparis(List<Siparis> lstSiparis) {
        this.lstSiparis = lstSiparis;
    }

    public BigDecimal getToplamSiparisTutari() {
        return toplamSiparisTutari;
    }

    public void setToplamSiparisTutari(BigDecimal toplamSiparisTutari) {
        this.toplamSiparisTutari = toplamSiparisTutari;
    }

    public BigDecimal getIskontoluFiyat() {
        return iskontoluFiyat;
    }

    public void setIskontoluFiyat(BigDecimal iskontoluFiyat) {
        this.iskontoluFiyat = iskontoluFiyat;
    }

    public BigDecimal getKalanBorc() {
        return kalanBorc;
    }

    public void setKalanBorc(BigDecimal kalanBorc) {
        this.kalanBorc = kalanBorc;
    }

    public String getMusteriNotu() {
        return musteriNotu;
    }

    public void setMusteriNotu(String musteriNotu) {
        this.musteriNotu = musteriNotu;
    }

    public Date getTeslimTarihi() {
        return teslimTarihi;
    }

    public void setTeslimTarihi(Date teslimTarihi) {
        this.teslimTarihi = teslimTarihi;
    }

    public EnumUtil.SIPARIS_DURUMU getSiparis_durumu() {
        return siparis_durumu;
    }

    public void setSiparis_durumu(EnumUtil.SIPARIS_DURUMU siparis_durumu) {
        this.siparis_durumu = siparis_durumu;
    }
}
