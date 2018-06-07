package tr.com.dev.haliYikama.server.helper;

import com.google.common.io.ByteSource;
import com.google.common.io.Resources;
import com.namics.commons.random.RandomData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import tr.com.dev.haliYikama.server.authentication.JwtUser;
import tr.com.dev.haliYikama.server.authentication.JwtUserFactory;
import tr.com.dev.haliYikama.server.persist.models.User;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 * Created by ramazancesur on 5/19/18.
 */
public class Helper {

    private static Logger LOGGER = LoggerFactory.getLogger(Helper.class);

    public Properties getRestrictProp(String propsFile, String restrictElement) {
        Properties props = new Properties();

        Properties properties = this.loadProperties(propsFile);
        properties.entrySet().stream()
                .filter(entrySet -> entrySet.getKey().toString().contains(restrictElement))
                .forEach(x -> {
                    props.put(x.getKey(), x.getValue());
                });
        return props;
    }

    public String encriptData(String data) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String criptedData = passwordEncoder.encode(data);
        return criptedData;
    }

    public <T extends Object> T createDummyData(Class<T> clazz) {
        return RandomData.random(clazz);
    }

    public JwtUser createJwtUser(User user) {
        JwtUser jwtUser = JwtUserFactory.create(user);
        return jwtUser;
    }

    public Properties loadProperties(String filename) {
        URL url = Resources.getResource(filename);
        final ByteSource byteSource = Resources.asByteSource(url);
        final Properties props = new Properties();

        try (InputStream inputStream = byteSource.openBufferedStream()) {
            props.load(inputStream);
            props.list(System.out);
        } catch (IOException e) {
            LOGGER.error("openBufferedStream failed!", e);
        }
        return props;
    }

}
