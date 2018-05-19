package tr.com.dev.haliYikama.server.persist.models;

import tr.com.dev.haliYikama.server.utils.EnumUtil;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ramazancesur on 5/19/18.
 */
@Entity
@Table(name = "FIRMA")
public class Firma extends User {
    @ManyToOne
    @JoinColumn(name = "FIRMA_YETKILISI")
    private User firmaYetkilisi;

    @Column(name = "FIRMA_ADI")
    private String firmaAdi;

    @OneToMany
    @JoinColumn(name = "TEL_FAX")
    private List<Telefon> lstTelAndFax;

    @Column(name = "KUNYE")
    private String firmaKunyesi;

    @Column(name = "VERGI_NO")
    private String vergiNo;


    public User getFirmaYetkilisi() {
        return firmaYetkilisi;
    }

    public void setFirmaYetkilisi(User firmaYetkilisi) {
        this.firmaYetkilisi = firmaYetkilisi;
    }

    public String getFirmaAdi() {
        return firmaAdi;
    }

    public void setFirmaAdi(String firmaAdi) {
        this.firmaAdi = firmaAdi;
    }

    public List<Telefon> getLstTelAndFax() {
        return lstTelAndFax;
    }

    public void setLstTelAndFax(List<Telefon> lstTelAndFax) {
        this.lstTelAndFax = lstTelAndFax;
    }

    public String getFirmaKunyesi() {
        return firmaKunyesi;
    }

    public void setFirmaKunyesi(String firmaKunyesi) {
        this.firmaKunyesi = firmaKunyesi;
    }

    public String getVergiNo() {
        return vergiNo;
    }

    public void setVergiNo(String vergiNo) {
        this.vergiNo = vergiNo;
    }
}
