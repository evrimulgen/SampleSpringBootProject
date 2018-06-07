package tr.com.dev.haliYikama.server.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import tr.com.dev.haliYikama.server.helper.Helper;
import tr.com.dev.haliYikama.server.jaxb.doviz.Currency;
import tr.com.dev.haliYikama.server.jaxb.doviz.TarihXML;
import tr.com.dev.haliYikama.server.persist.models.Doviz;
import tr.com.dev.haliYikama.server.service.interfaces.IDovizService;

import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

@Component
@Transactional
public class DovizKuruJob {

    private static final Logger LOGGER = LoggerFactory.getLogger(DovizKuruJob.class);
    @Autowired
    private IDovizService dovizService;
    private Helper helper = new Helper();

    @Scheduled(cron = "0 0 2,18 * * ?")
    public void dovizKuruGuncelle() throws Exception {
        try {
            Doviz kayitliDoviz = new Doviz();
            List<Doviz> lstDoviz = getGuncelDovizKuru();
            for (Doviz doviz : lstDoviz) {
                kayitliDoviz = dovizService.getDovizKodunaGore(doviz.getDovizKodu());
                System.out.println("Doviz Alis ve Satıs Fiyatlari Guncellendi...");
                if (kayitliDoviz != null) {
                    kayitliDoviz.setDovizAlis(doviz.getDovizAlis());
                    kayitliDoviz.setDovizSatis(doviz.getDovizSatis());
                    dovizService.update(kayitliDoviz);
                } else {
                    dovizService.add(doviz);
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            LOGGER.error("Doviz Kurları çekilirken hata oluştu... " + e.getMessage());
        }

    }

    public List<Doviz> getGuncelDovizKuru() throws Exception {
        List<Doviz> lstDoviz = new LinkedList<Doviz>();
        String xml = Helper.readUrl("http://www.tcmb.gov.tr/kurlar/today.xml");
        TarihXML tarihXML = (TarihXML) Helper.unmarshal(xml, TarihXML.class);
        for (Currency currency : tarihXML.getLstCurrency()) {
            Doviz doviz = new Doviz();
            doviz.setBirim(currency.getUnit());
            doviz.setDovizAlis(BigDecimal.valueOf(currency.getAlisFiyati()));
            doviz.setDovizKodu(currency.getKod());
            doviz.setDovizSatis(BigDecimal.valueOf(currency.getSatisFiyati()));
            dovizService.add(doviz);
            lstDoviz.add(doviz);
        }
        return lstDoviz;
    }
}