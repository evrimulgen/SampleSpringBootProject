package tr.com.dev.haliYikama.server;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = Application.class)
public class ApplicationTests {
    private Logger logger = LoggerFactory.getLogger(ApplicationTests.class);

    @Before
    public void setUp() throws Exception {
        System.out.println("test procedure is initializing... ");
    }

    @Test
    public void contextLoads() {

    }

    @After
    public void tearDown() throws Exception {
        System.out.println("test procedure is finished... ");

    }
}
