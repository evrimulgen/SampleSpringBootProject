package tr.com.dev.haliYikama.server.authentication.controller.getClasses;

import org.reflections.Reflections;
import tr.com.dev.haliYikama.server.persist.models.Personel;
import tr.com.dev.haliYikama.server.persist.models.User;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * Created by ramazancesur on 7/15/18.
 */
public class ReflectionUtils {


    public static List<Class> getClassOfSubClass(Class clazz, String searchingPackageName) throws IOException, ClassNotFoundException {
        List<Class> lstResult = getClasses(searchingPackageName);
        List<Class> lstSubClass = new LinkedList<>();
        for (Class resultClass : lstResult) {
            try {
                if (resultClass.getSuperclass() != null &&
                        (resultClass.getSuperclass().equals(clazz) || resultClass.equals(clazz))) {
                    lstSubClass.add(resultClass);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return lstSubClass;
    }

    /**
     * Scans all classes accessible from the context class loader which belong to the given package and subpackages.
     *
     * @param packageName The base package
     * @return The classes
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public static List<Class> getClasses(String packageName)
            throws ClassNotFoundException, IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        assert classLoader != null;
        String path = packageName.replace('.', '/');
        Enumeration<URL> resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList<File>();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        ArrayList<Class> classes = new ArrayList<Class>();
        for (File directory : dirs) {
            classes.addAll(findClasses(directory, packageName));
        }
        return classes;
    }

    /**
     * Recursive method used to find all classes in a given directory and subdirs.
     *
     * @param directory   The base directory
     * @param packageName The package name for classes found inside the base directory
     * @return The classes
     * @throws ClassNotFoundException
     */
    private static List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
        List<Class> classes = new ArrayList<Class>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
            }
        }
        return classes;
    }

    public List<Class<? extends User>> getSubClassList() {
        // package Full Name
        Reflections reflections = new Reflections("tr.com.dev");
        Set<Class<? extends Personel>> classes = reflections.getSubTypesOf(Personel.class);
        List<Class<? extends User>> lstClasses = new LinkedList<>(classes);
        return lstClasses;
    }


}
