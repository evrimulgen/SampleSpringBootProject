package tr.com.dev.haliYikama.server.server;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import tr.com.dev.haliYikama.server.helper.Helper;
import tr.com.dev.haliYikama.server.persist.dao.IAdresDao;
import tr.com.dev.haliYikama.server.persist.models.Adres;
import tr.com.dev.haliYikama.server.server.interfaces.IAdresService;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class AdresServiceTest {
    private IAdresService adresServiceMock;
    private IAdresDao adresDaoMock;

    @Before
    public void setUp() {
        adresDaoMock = Mockito.mock(IAdresDao.class);
        adresServiceMock = new AdresService(adresDaoMock);
    }

    @Test
    public void getOneTest() {
        Helper helper = new Helper();
        Adres adres = helper.createDummyData(Adres.class);
        when(adresDaoMock.getOne(1l)).thenReturn(adres);
        boolean adrBoolean = adresServiceMock.add(helper.createDummyData(Adres.class));
        assertEquals(true, adrBoolean);
    }

    @After
    public void tearDown() {
        List<Adres> lstAdresService = adresServiceMock.getAll();
        for (Adres adres : lstAdresService) {
            adresServiceMock.remove(adres);
            System.out.println(adres.getAdres());
        }
        System.out.println("işlem başarılı...");
    }
}