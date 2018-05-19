package tr.com.dev.haliYikama.server.persist.models;

import tr.com.dev.haliYikama.server.utils.BaseEntity;

import javax.persistence.*;

/**
 * Created by ramazancesur on 5/19/18.
 */
@Table
@Entity(name = "MUSTERI")
public class Musteri extends BaseEntity {
    @Column(name = "ADI")
    private String adi;

    @Column(name = "SOYADI")
    private String soyadi;

    @ManyToOne
    @JoinColumn(name = "FIRMA")
    private Firma firma;

    @ManyToOne
    @JoinColumn(name = "TELEFON")
    private Telefon telefon;

    @ManyToOne
    @JoinColumn(name = "ADRES")
    private Adres adres;

    @Column(name = "FIRMA_MUSTERI_OID")
    private Long firmaMusteriOid;


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

    public Firma getFirma() {
        return firma;
    }

    public void setFirma(Firma firma) {
        this.firma = firma;
    }

    public Telefon getTelefon() {
        return telefon;
    }

    public void setTelefon(Telefon telefon) {
        this.telefon = telefon;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public Long getFirmaMusteriOid() {
        return firmaMusteriOid;
    }

    public void setFirmaMusteriOid(Long firmaMusteriOid) {
        this.firmaMusteriOid = firmaMusteriOid;
    }
}
