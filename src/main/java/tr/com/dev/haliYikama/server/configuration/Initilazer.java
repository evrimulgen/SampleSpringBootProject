package tr.com.dev.haliYikama.server.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import tr.com.dev.haliYikama.server.helper.Helper;
import tr.com.dev.haliYikama.server.persist.models.Adres;
import tr.com.dev.haliYikama.server.persist.models.Firma;
import tr.com.dev.haliYikama.server.persist.models.Telefon;
import tr.com.dev.haliYikama.server.persist.models.User;
import tr.com.dev.haliYikama.server.service.interfaces.IAdresService;
import tr.com.dev.haliYikama.server.service.interfaces.IFirmaService;
import tr.com.dev.haliYikama.server.service.interfaces.ITelefonService;
import tr.com.dev.haliYikama.server.service.interfaces.IUserService;
import tr.com.dev.haliYikama.server.utils.EnumUtil;

import java.util.Arrays;
import java.util.List;

@Component
public class Initilazer implements ApplicationRunner {

    @Autowired
    IAdresService adresServiceMock;

    @Autowired
    private Environment environment;

    @Autowired
    private IUserService userService;

    @Autowired
    private IAdresService adresService;

    @Autowired
    private ITelefonService telefonService;

    @Autowired
    private IFirmaService firmaService;

    private Helper helper = new Helper();

    @Override
    public void run(ApplicationArguments args) {
        String hbm2ddl = environment.getProperty("hibernate.hbm2ddl.auto");
        if (hbm2ddl.contains("update")) {
            List<User> lstUser = userService.getAll();
            if (lstUser.size() == 0) {
                createInitData();
            }
        } else if (hbm2ddl.contains("create")) {
            createInitData();
        }
    }

    private void createInitData() {
        User user = new User();

        Adres adres = new Adres();
        adres.setAdresType(EnumUtil.ADRES_TYPE.GENEL);
        adres.setAdres("Ankara/Turkey");
        adresService.add(adres);

        Telefon telefon = new Telefon();
        telefon.setTel("537 561 7150");
        telefon.setTelType(EnumUtil.TEL_TYPE.CEP);
        telefonService.add(telefon);

        user.setePosta("ramazancesur3@gmail.com");
        user.setKullaniciAdi("admin");
        String cyriptedPassword = helper.encriptData("admin");
        user.setSifre(cyriptedPassword);
        user.setYetkiType(EnumUtil.YETKI_TYPE.SUPER_ADMIN);
        user.setEsasAdres(adres);
        user.setEsasTel(telefon);
        userService.add(user);


        Firma firma = new Firma();
        firma.setFirmaAdi("ADMIN");
        firma.setKullaniciAdi(user.getKullaniciAdi());
        firma.setSifre(cyriptedPassword);
        firma.setFirmaKunyesi("asj");
        firma.setLstTelAndFax(Arrays.asList(user.getEsasTel()));
        firma.setVergiNo("hdhd");
        firma.setFirmaYetkilisi(user);

        firmaService.add(firma);

    }
}
