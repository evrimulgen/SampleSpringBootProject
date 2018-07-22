package tr.com.dev.haliYikama.server.authentication.client;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import tr.com.dev.haliYikama.server.Application;
import tr.com.dev.haliYikama.server.authentication.JwtUser;
import tr.com.dev.haliYikama.server.authentication.service.JwtAuthenticationResponse;
import tr.com.dev.haliYikama.server.helper.Helper;
import tr.com.dev.haliYikama.server.persist.models.Adres;
import tr.com.dev.haliYikama.server.persist.models.Telefon;
import tr.com.dev.haliYikama.server.persist.models.User;
import tr.com.dev.haliYikama.server.service.interfaces.IAdresService;
import tr.com.dev.haliYikama.server.service.interfaces.ITelefonService;
import tr.com.dev.haliYikama.server.service.interfaces.IUserService;
import tr.com.dev.haliYikama.server.utils.EnumUtil;

import static org.junit.Assert.assertEquals;

/**
 * Created by ramazancesur on 5/23/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = Application.class)
@ActiveProfiles("testProfile")
public class RAuthenticationTest {
 /*   @MockBean
    private IUserDao userDaoMock;
    @Autowired
    private IUserService userServiceMock;*/

    @Autowired
    private IUserService userServiceMock;

    @Autowired
    private IAdresService adresService;

    @Autowired
    private ITelefonService telefonService;

    private User user;

    private Helper helper;

    @Before
    public void setUp() {
        helper = new Helper();
        user = helper.createDummyData(User.class);

        Adres adres = helper.createDummyData(Adres.class);
        adres.setEntityState(EnumUtil.EntityState.ACTIVE);
        adres.setOid(null);
        adresService.add(adres);

        Telefon telefon = helper.createDummyData(Telefon.class);
        telefon.setOid(null);
        telefon.setEntityState(EnumUtil.EntityState.ACTIVE);
        telefonService.add(telefon);

        user.setOid(null);
        user.setEntityState(EnumUtil.EntityState.ACTIVE);
        user.setEsasAdres(adres);
        user.setEsasTel(telefon);

        userServiceMock.add(user);

        System.out.println("Test Module is starting... ");
    }

    @Test
    public void testGetAuthTokenCookie() {
        String userName = user.getKullaniciAdi();
        try {
            //  when(userServiceMock.get(1l)).thenReturn(user);
            JwtUser jwtUser = helper.createJwtUser(user);
            JwtAuthenticationResponse response = RAuthentication.getAuthTokenCookie(jwtUser);
            System.out.println(response.getToken());
            assertEquals(userName, response.getUserName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        System.out.println("Test Module is finished");
    }
}