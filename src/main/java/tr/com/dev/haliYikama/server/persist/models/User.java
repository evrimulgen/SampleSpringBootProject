package tr.com.dev.haliYikama.server.persist.models;

import tr.com.dev.haliYikama.server.utils.BaseEntity;
import tr.com.dev.haliYikama.server.utils.EnumUtil;

import javax.persistence.*;

/**
 * Created by ramazancesur on 5/19/18.
 */
@Entity
@Table(name = "USERS")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User extends BaseEntity {
    @Column(name = "KULLANICI_ADI")
    private String kullaniciAdi;

    @Column(name = "YETKI_TYPE")
    private EnumUtil.YETKI_TYPE yetkiType;

    @Column(name = "EPOSTA")
    private String ePosta;

    @Column(name = "SIFRE")
    private String sifre;

    @ManyToOne
    @JoinColumn(name = "ESAS_ADRES")
    private Adres esasAdres;

    @ManyToOne
    @JoinColumn(name = "ESAS_TEL")
    private Telefon esasTel;

    public Telefon getEsasTel() {
        return esasTel;
    }

    public void setEsasTel(Telefon esasTel) {
        this.esasTel = esasTel;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public EnumUtil.YETKI_TYPE getYetkiType() {
        return yetkiType;
    }

    public void setYetkiType(EnumUtil.YETKI_TYPE yetkiType) {
        this.yetkiType = yetkiType;
    }

    public String getePosta() {
        return ePosta;
    }

    public void setePosta(String ePosta) {
        this.ePosta = ePosta;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public Adres getEsasAdres() {
        return esasAdres;
    }

    public void setEsasAdres(Adres esasAdres) {
        this.esasAdres = esasAdres;
    }
}
