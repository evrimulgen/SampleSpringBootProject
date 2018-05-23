package tr.com.dev.haliYikama.server.authentication.client;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import tr.com.dev.haliYikama.server.Application;
import tr.com.dev.haliYikama.server.persist.dao.IUserDao;

/**
 * Created by ramazancesur on 5/23/18.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
public class RAuthenticationTest {

    private IUserDao userDao;


    @Before
    public void setUp() throws Exception {
        System.out.println("Test Module is starting... ");
    }

    @Test
    public void testGetAuthTokenCookie() {


    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Test Module is finished");

    }
}