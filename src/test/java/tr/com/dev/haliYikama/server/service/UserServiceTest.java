package tr.com.dev.haliYikama.server.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import tr.com.dev.haliYikama.server.helper.Helper;
import tr.com.dev.haliYikama.server.persist.dao.IUserDao;
import tr.com.dev.haliYikama.server.persist.models.User;
import tr.com.dev.haliYikama.server.service.interfaces.IUserService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by ramazancesur on 5/23/18.
 */
public class UserServiceTest {

    private IUserDao userDaoMock;
    private IUserService userServiceMock;
    private Helper helper;

    @Before
    public void setUp() throws Exception {
        userDaoMock = Mockito.mock(IUserDao.class);
        userServiceMock = new UserService(userDaoMock);
        helper = new Helper();
    }

    @Test
    public void testFindByKullaniciAdi() throws Exception {
        User user = helper.createDummyData(User.class);
        user.setOid(1l);
        String userName = user.getKullaniciAdi();
        when(userServiceMock.get(1l)).thenReturn(user);
        assertEquals(1l, userServiceMock.findByKullaniciAdi(userName).getOid().longValue());


    }
}