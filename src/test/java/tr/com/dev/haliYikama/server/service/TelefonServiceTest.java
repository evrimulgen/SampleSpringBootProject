package tr.com.dev.haliYikama.server.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import tr.com.dev.haliYikama.server.helper.Helper;
import tr.com.dev.haliYikama.server.persist.models.Telefon;
import tr.com.dev.haliYikama.server.service.interfaces.ITelefonService;
import tr.com.dev.haliYikama.server.utils.EnumUtil;

import static org.junit.Assert.assertEquals;

/**
 * Created by ramazancesur on 5/24/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
@ActiveProfiles("testProfile")
public class TelefonServiceTest {
    @Autowired
    private ITelefonService telefonService;

    private Helper helper;

    @Before
    public void setUp() throws Exception {
        helper = new Helper();
        for (int i = 0; i < 100; i++) {
            Telefon telefon = helper.createDummyData(Telefon.class);
            telefon.setOid(null);
            telefon.setEntityState(EnumUtil.EntityState.ACTIVE);
            telefonService.add(telefon);

        }
    }

    @Test
    public void testGet() throws Exception {
        assertEquals(telefonService.get(99l).getOid().intValue(), 99);

    }
}