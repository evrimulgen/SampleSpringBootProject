package tr.com.dev.haliYikama.server.authentication.client;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import tr.com.dev.haliYikama.server.Application;
import tr.com.dev.haliYikama.server.authentication.JwtUser;
import tr.com.dev.haliYikama.server.authentication.service.JwtAuthenticationResponse;
import tr.com.dev.haliYikama.server.helper.Helper;
import tr.com.dev.haliYikama.server.persist.dao.IUserDao;
import tr.com.dev.haliYikama.server.persist.models.User;
import tr.com.dev.haliYikama.server.service.interfaces.IUserService;
import tr.com.dev.haliYikama.server.utils.EnumUtil;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by ramazancesur on 5/23/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = Application.class)
public class RAuthenticationTest {
    @MockBean
    private IUserDao userDaoMock;
    @Autowired
    private IUserService userServiceMock;
    private Helper helper;
    @Before
    public void setUp() {
      /*  userDaoMock = Mockito.mock(IUserDao.class);
        userServiceMock= new UserService(userDaoMock);*/
        helper = new Helper();
        System.out.println("Test Module is starting... ");
    }

    @Test
    public void testGetAuthTokenCookie() {
        User user = helper.createDummyData(User.class);
        String userName = user.getKullaniciAdi();
        try {
            user.setOid(1l);
            user.setEntityState(EnumUtil.EntityState.ACTIVE);
            when(userServiceMock.get(1l)).thenReturn(user);
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