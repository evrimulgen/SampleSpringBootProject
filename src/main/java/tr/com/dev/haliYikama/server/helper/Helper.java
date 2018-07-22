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

import javax.xml.bind.*;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;

/**
 * Created by ramazancesur on 5/19/18.
 */
public class Helper {

    private static Logger LOGGER = LoggerFactory.getLogger(Helper.class);

    public static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();
            BufferedReader reader2 = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF8"), 8);
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader2.read(chars)) != -1)
                buffer.append(chars, 0, read);
            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }

    /**
     * Marshalling supplied object to XML document by JAXB annotations and
     * serializing it to String
     *
     * @param obj object to be marshalled
     * @return serialized XML document
     * @throws MarshalException
     */
    public static String marshal(Object obj) throws MarshalException {
        try {
            JAXBContext jc = JAXBContext.newInstance(obj.getClass());
            StringWriter sw = new StringWriter();
            Marshaller m = jc.createMarshaller();
            // m.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(obj, sw);
            return sw.toString();
        } catch (JAXBException jbe) {
            throw new MarshalException("Error when marshalling " + obj.getClass().getCanonicalName(), jbe);
        }
    }

    /**
     * Unmarshalling itself from XML document by JAXB annotations
     *
     * @param xml   xml document serialized as String
     * @param clazz Class to which shoud be object unmarshalled
     * @return serialized XML document
     * @throws JAXBException
     */
    public static Object unmarshal(String xml, Class clazz) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(clazz);
        Unmarshaller u = jc.createUnmarshaller();
        return u.unmarshal(new StringReader(xml));
    }

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
