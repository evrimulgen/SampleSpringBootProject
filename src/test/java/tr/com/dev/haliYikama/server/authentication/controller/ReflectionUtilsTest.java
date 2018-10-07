package tr.com.dev.haliYikama.server.authentication.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tr.com.dev.haliYikama.server.authentication.controller.getClasses.ReflectionUtils;
import tr.com.dev.haliYikama.server.persist.models.User;

import java.io.IOException;
import java.util.List;

/**
 * Created by ramazancesur on 7/15/18.
 */
public class ReflectionUtilsTest {
    ReflectionUtils reflectionUtils;

    @Before
    public void setUp() throws Exception {
        reflectionUtils = new ReflectionUtils();
    }

    @Test
    public void getClassOfSubClasses() {
        try {
            List<Class> classes = ReflectionUtils.getClassOfSubClass(User.class, "tr.com.dev");
            for (Class clazz : classes) {
                System.out.println(clazz.getName());
            }
            Assert.assertTrue(true);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail();
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void getClasses() {
        try {
            List<Class> classes = ReflectionUtils.getClasses("tr.com.dev");
            for (Class clazz : classes) {
                System.out.println(clazz.getName());
            }
            Assert.assertTrue(true);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail();
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void testGetSubClassList() throws Exception {
        boolean state = true;
        try {
            List<Class<? extends User>> lstClasses = reflectionUtils.getSubClassList();
            lstClasses.forEach(clazz -> {
                System.out.println(clazz.getName());
            });
        } catch (Exception ex) {
            ex.printStackTrace();
            state = false;
        }
        Assert.assertTrue(state);
    }
}