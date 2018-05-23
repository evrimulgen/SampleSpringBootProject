package tr.com.dev.haliYikama.server.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import tr.com.dev.haliYikama.server.helper.Helper;
import tr.com.dev.haliYikama.server.persist.dao.IUserDao;
import tr.com.dev.haliYikama.server.persist.models.User;
import tr.com.dev.haliYikama.server.utils.EnumUtil;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by ramazancesur on 5/23/18.
 */

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    Helper helper = new Helper();
    @Mock
    private IUserDao userDaoMock;
    @InjectMocks
    private UserService userServiceMock;
    private User user;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        user = helper.createDummyData(User.class);
        user.setOid(1l);
        user.setEntityState(EnumUtil.EntityState.ACTIVE);

        when(userServiceMock.getAll()).thenReturn(Arrays.asList(user));
        when(userServiceMock.findByKullaniciAdi(user.getKullaniciAdi())).thenReturn(user);
    }

    @Test
    public void testFindByKullaniciAdi() {
        assertEquals(userServiceMock.getAll().get(0), user);
        assertEquals(userServiceMock.findByKullaniciAdi(user.getKullaniciAdi()), user);
    }
}
