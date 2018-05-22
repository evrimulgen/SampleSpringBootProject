package tr.com.dev.haliYikama.server.persist.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import tr.com.dev.haliYikama.server.helper.Helper;
import tr.com.dev.haliYikama.server.persist.models.Adres;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class IAdresDaoTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private IAdresDao adresDao;

    private Helper helper;

    @Before
    public void setUp() {
        helper = new Helper();
    }

    @Test
    public void findByAdresName() {
        Adres adres = helper.createDummyData(Adres.class);
        adres.setOid(null);
        entityManager.persist(adres);
        List<Adres> lstData = adresDao.getFirmaAdresleri();
        assertEquals(1, lstData.size());
    }
}