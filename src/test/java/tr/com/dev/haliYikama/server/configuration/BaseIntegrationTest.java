package tr.com.dev.haliYikama.server.configuration;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by ramazancesur on 5/24/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
@ActiveProfiles("testProfile")
public abstract class BaseIntegrationTest {

}
